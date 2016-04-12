package com.puhui.demo.service.impl;

import com.puhui.demo.mapper.RestfulUserMapper;
import com.puhui.demo.service.RestfulUserService;
import com.puhui.demo.vo.RestfulUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wentong on 2016/4/12.
 */
@Service("restfulUserService")
public class RestfulUserServiceImpl implements RestfulUserService {
    @Autowired
    private RestfulUserMapper restfulUserMapper;

    @Override
    public void insertUser(RestfulUser user) {
        restfulUserMapper.insertUser(user);
    }
}
