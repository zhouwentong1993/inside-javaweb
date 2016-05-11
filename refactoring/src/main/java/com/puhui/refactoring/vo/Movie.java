package com.puhui.refactoring.vo;

/**
 * Created by wentong on 2016/5/11.
 * 影片实体类
 */
public class Movie {
    public static final int CHILDREN = 2; // 儿童片
    public static final int REGULAR = 0; // 普通片
    public static final int NEW_RELEASE = 1; // 新片

    private String title; // 名称
    private int priceCode; // 价码，对应的上述几个片子类型。

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
