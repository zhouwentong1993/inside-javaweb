package com.puhui.demo.web.controller;

import com.puhui.demo.vo.RestfulUser;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wentong on 2016/4/12.
 */
@RequestMapping("user")
@Api(value = "User", description = "用户相关")
@RestController
public class RestfulUserController {
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", nickname="getUser", value = "通过 ID 获取用户")
    public RestfulUser queryUserById(@PathVariable Long id) {
        return null;
    }
}
