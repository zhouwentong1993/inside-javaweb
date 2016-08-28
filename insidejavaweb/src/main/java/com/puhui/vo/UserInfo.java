package com.puhui.vo;

/**
 * Created by wentong on 2016/8/28.
 * 用户信息类
 */
public class UserInfo {
    private int id;
    private String userInfoDesc;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userInfoDesc='" + userInfoDesc + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserInfoDesc() {
        return userInfoDesc;
    }

    public void setUserInfoDesc(String userInfoDesc) {
        this.userInfoDesc = userInfoDesc;
    }
}
