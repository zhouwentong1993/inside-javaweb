package main.java.com.puhui.web.controller;

import com.puhui.password.CommonPassword;
import com.puhui.password.vo.PasswordVo;
import com.puhui.service.PasswordService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by wentong on 2016/4/9.
 */
@RequestMapping("password")
@Controller
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @RequestMapping(value = "savePassword", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    //TODO 待处理响应中文乱码问题，可以通过过滤器实现一下。
    public Object savePassword(HttpServletRequest request) throws UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
        try {
            String mobile = request.getParameter("mobile");
            String password = request.getParameter("password");
            System.out.println("接收到手机号为：" + mobile);
            System.out.println("接收到原密码为：" + password);
            // TODO 没有做的事情，检验用户是否注册过，如果注册过，不应该让他再次注册。
            // TODO 代码写的有问题，应该把这些都放到 Service 里面去。
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
            jsonObject.put("msg", "注册成功");
        } catch (Exception e) {
            jsonObject.put("code", -1);
            jsonObject.put("msg", "注册失败");
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "checkPassword", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public Object checkPassword(HttpServletRequest request) {
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        JSONObject result = passwordService.validPassword(mobile, password);
        return result.toString();
    }

    @RequestMapping(value = "changePassword", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public Object changePassword(HttpServletRequest request) throws UnsupportedEncodingException {
//        response.setHeader("Cache-Control", "no-cache");
//        response.setContentType("text/json;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        JSONObject result = passwordService.changePassword(mobile, password);
        String s = result.toString();
        String gbk = new String(s.getBytes(), "gbk");
        String utf8 = new String(s.getBytes(), "utf-8");
        System.out.println("gbk: " + gbk);
        System.out.println("utf8: " + utf8);
        return s;
    }
}
