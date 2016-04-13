package com.puhui.demo.service;

import com.puhui.demo.vo.RestfulUser;

/**
 * Created by wentong on 2016/4/12.
 */
public interface RestfulUserService {
    void insertUser(RestfulUser user);

    RestfulUser getUserById(Long id);
}
