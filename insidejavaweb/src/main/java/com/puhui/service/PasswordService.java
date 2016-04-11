package com.puhui.service;

import com.puhui.password.vo.PasswordVo;
import net.sf.json.JSONObject;

/**
 * Created by wentong on 2016/4/9.
 * PasswordService
 */
public interface PasswordService {
    void insertPassword(PasswordVo passwordVo);

    JSONObject validPassword(String mobile, String password);

    JSONObject changePassword(String mobile, String password);
}
