package com.puhui.mapper;

import com.puhui.password.vo.PasswordVo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wentong on 2016/4/8.
 * 密码 Mapper
 */
public interface PasswordMapper {

    /**
     * 将密码存入数据库
     *
     * @param passwordVo 密码实体
     */
    void savePassword(PasswordVo passwordVo);

    /**
     * 通过手机号找到盐
     *
     * @param mobile 手机号
     * @return 盐
     */
    PasswordVo getVoByMobile(@Param("mobile") String mobile);

    /**
     * 根据手机号修改密码
     * @param salt 修改后的盐值
     * @param password 修改后的密码
     * @param mobile 手机号
     */
    void updateSaltAndPasswordByMobile(@Param("salt") String salt,
                                       @Param("password") String password,
                                       @Param("mobile") String mobile);
}
