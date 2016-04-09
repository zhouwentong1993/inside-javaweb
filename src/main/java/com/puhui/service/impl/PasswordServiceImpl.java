package com.puhui.service.impl;

import com.puhui.constant.CommonConstants;
import com.puhui.mapper.PasswordMapper;
import com.puhui.password.CommonPassword;
import com.puhui.password.vo.PasswordVo;
import com.puhui.service.PasswordService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wentong on 2016/4/9.
 */
@Service("passwordService")
public class PasswordServiceImpl implements PasswordService {
    @Autowired
    private PasswordMapper passwordMapper;

    @Override
    public void insertPassword(PasswordVo passwordVo) {
        passwordMapper.savePassword(passwordVo);
    }

    @Override
    public JSONObject validPassword(String mobile, String password) {
        JSONObject jsonObject = new JSONObject();
        // 这里考虑到登录的时候成功的概率比较高，所以将用户的所有数据返回，这样可以减少带宽。
        PasswordVo passwordVo = passwordMapper.getVoByMobile(mobile);
        if (passwordVo == null) {
            return getJson(jsonObject, "用户不存在", false);
        }
        String salt = passwordVo.getSalt();
        String mobile1 = passwordVo.getMobile();
        //TODO 需要做一点处理，如果发现用户没有盐怎么办？或许是多虑了。
        if (StringUtils.isEmpty(salt) || salt.length() != 6 || StringUtils.isEmpty(mobile1) || mobile1.length() != 11) {
            return getJson(jsonObject, "用户不存在", false);
        }
        String tempPassword = CommonPassword.getPassword(password, salt);
        if (!StringUtils.equals(passwordVo.getPassword(), tempPassword)) {
            return getJson(jsonObject, "用户名或用户不匹配", false);
        }
        return getJson(jsonObject, "校验通过，登录成功", true);
    }

    /**
     * 修改密码
     * @param mobile 手机号
     * @param password 密码
     * @return JsonObject
     */
    @Override
    public JSONObject changePassword(String mobile, String password) {
        JSONObject jsonObject = new JSONObject();
        try {
            // 这里考虑到登录的时候成功的概率比较高，所以将用户的所有数据返回，这样可以减少带宽。
            PasswordVo passwordVo = passwordMapper.getVoByMobile(mobile);
            if (passwordVo == null) {
                return getJson(jsonObject, "用户不存在，无法修改密码", false);
            }
            String salt = CommonPassword.getSalt();
            String newPassword = CommonPassword.getPassword(password, salt);
            passwordMapper.updateSaltAndPasswordByMobile(salt, newPassword, mobile);
            getJson(jsonObject, "修改密码成功。", true);
        } catch (Exception e) {
            System.out.println("修改密码失败");
            getJson(jsonObject, "修改密码失败", false);
        }
        return jsonObject;
    }

    private JSONObject getJson(JSONObject jsonObject, String msg, boolean isOk) {
        if (isOk) {
            jsonObject.put("code", CommonConstants.RIGHT_CODE);
            jsonObject.put("msg", msg);
        } else {
            jsonObject.put("code", CommonConstants.ERROR_CODE);
            jsonObject.put("msg", msg);
        }
        return jsonObject;
    }
}
