package com.puhui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wentong on 2016/7/7.
 * 用户 Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test")
    public void test() {
        int i = 0;
        System.out.println("test");
    }
}
