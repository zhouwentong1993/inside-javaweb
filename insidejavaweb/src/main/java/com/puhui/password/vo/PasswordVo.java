package com.puhui.password.vo;

/**
 * Created by wentong on 2016/4/8.
 * 密码 VO
 */
public class PasswordVo {
    private Long id;
    private String mobile;
    private String salt;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PasswordVo{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
