package com.puhui.demo.web.controller;

import com.puhui.demo.service.RestfulUserService;
import com.puhui.demo.vo.RestfulUser;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wentong on 2016/4/12.
 */
@RequestMapping("/api/v1/")
@Api(value = "用户接口", protocols = "JSON")
@RestController
public class RestfulUserController {

    @Autowired
    private RestfulUserService restfulUserService;

    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", nickname="getUser", value = "通过 ID 获取用户")
    public RestfulUser queryUserById(@PathVariable Long id) {
        return restfulUserService.getUserById(id);
    }
}
