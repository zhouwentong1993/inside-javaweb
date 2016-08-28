package com.puhui.web.controller;

import com.puhui.vo.User;
import com.puhui.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wentong on 2016/8/28.
 * 用户相关 Controller
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("getUser")
    public Object getUser(User user, UserInfo userInfo) {
        System.out.println(user);
        System.out.println(userInfo);
        user.setUserInfoId(userInfo.getId());
        System.out.println(user);
        System.out.println(userInfo);
        return null;
    }
}
