package com.puhui.refactoring.vo;

/**
 * Created by wentong on 2016/5/13.
 * 普通片价格类
 */
public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
