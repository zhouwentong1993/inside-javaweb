package com.puhui.mapper;

import com.puhui.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wentong on 2016/3/29.
 */
@Repository
public interface UserMapper {
    List<User> queryUserByUserName(@Param("username") String username, User user);
    User queryUserByUserName1(User user1, User user2);


}
