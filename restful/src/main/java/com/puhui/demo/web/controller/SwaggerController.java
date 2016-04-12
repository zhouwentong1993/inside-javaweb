package com.puhui.demo.web.controller;

import com.wordnik.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wentong on 2016/4/13.
 */
@Api(value = "User", description = "用户相关")
@RestController
public class SwaggerController {
//    @RequestMapping(value = "/swagger-ui.html",method = RequestMethod.GET)
////    @ApiOperation(httpMethod = "GET", nickname="getUser", value = "通过 ID 获取用户")
//    public ModelAndView queryUserById() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("../swagger/");
//        return modelAndView;
//    }
}
