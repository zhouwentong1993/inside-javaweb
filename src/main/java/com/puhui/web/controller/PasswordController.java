package com.puhui.web.controller;

import com.puhui.password.CommonPassword;
import com.puhui.password.vo.PasswordVo;
import com.puhui.service.PasswordService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by wentong on 2016/4/9.
 */
@RequestMapping("password")
@Controller
public class PasswordController {

    @Autowired
    private PasswordService passwordService;
    @RequestMapping("/savePassword")
    @ResponseBody
    //TODO 待处理响应中文乱码问题，可以通过过滤器实现一下。
    public Object savePassword(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            String mobile = request.getParameter("mobile");
            String password = request.getParameter("password");
            System.out.println("接收到手机号为：" + mobile);
            System.out.println("接收到原密码为：" + password);
            String salt = CommonPassword.getSalt();
            String finalPassword = CommonPassword.getPassword(password, salt);
            System.out.println("加密后的结果为：" + finalPassword);
            System.out.println("得到的盐值为：" + salt);
            PasswordVo passwordVo = new PasswordVo();
            passwordVo.setMobile(mobile);
            passwordVo.setSalt(salt);
            passwordVo.setPassword(finalPassword);
            passwordService.insertPassword(passwordVo);

            jsonObject.put("code", 1);
            jsonObject.put("msg", "OK~");
        } catch (Exception e) {
            jsonObject.put("code", -1);
            jsonObject.put("msg", "NOT OK~");
        }
        return jsonObject.toString();
    }

    @RequestMapping("checkPassword")
    @ResponseBody
    public Object checkPassword(HttpServletRequest request) {
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        JSONObject result = passwordService.validPassword(mobile, password);
        return result.toString();
    }

    @RequestMapping("changePassword")
    @ResponseBody
    public Object changePassword(HttpServletRequest request) {
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        JSONObject result = passwordService.changePassword(mobile, password);
        return result.toString();
    }
}
