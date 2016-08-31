package com.puhui.web.controller;

import com.puhui.mapper.UserMapper;
import com.puhui.vo.User;
import com.puhui.vo.UserInfo;
import com.puhui.vo.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wentong on 2016/8/28.
 * 用户相关 Controller
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("getUser")
    public Object getUser(User user, UserInfo userInfo) {
        System.out.println("改了一个类");
        System.out.println("改了一个类");
        System.out.println(user);
        System.out.println(userInfo);
        userMapper.saveUserInfo(userInfo);
        user.setUserInfoId(userInfo.getId());
        userMapper.saveUser(user);
        System.out.println(user);
        System.out.println(userInfo);
        return null;
    }

    @RequestMapping(value = "getValue",method = RequestMethod.POST)
    @ResponseBody
    public Object getValue(@RequestBody List<Value> valueList) {
        System.out.println(valueList);
        return null;
    }
}
