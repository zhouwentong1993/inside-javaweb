package com.puhui.web.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wentong on 2016/3/29.
 */
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "/testGet",method = RequestMethod.GET)
    @ResponseBody
    public Object test(HttpServletRequest request) {
        String username = request.getParameter("username");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1);
        return jsonObject;
    }
}
