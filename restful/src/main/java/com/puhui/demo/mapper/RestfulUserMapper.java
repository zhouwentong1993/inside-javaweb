package com.puhui.demo.mapper;

import com.puhui.demo.vo.RestfulUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wentong on 2016/4/12.
 */
public interface RestfulUserMapper {
    
    void insertUser(RestfulUser user);

    RestfulUser getUserById(@Param("id") Long id);
}
