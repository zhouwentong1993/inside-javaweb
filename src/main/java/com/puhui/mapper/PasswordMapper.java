package com.puhui.mapper;

import com.puhui.password.vo.PasswordVo;

/**
 * Created by wentong on 2016/4/8.
 */
public interface PasswordMapper {

    /**
     * 将密码存入数据库
     * @param passwordVo 密码实体
     */
    void savePassword(PasswordVo passwordVo);
}
