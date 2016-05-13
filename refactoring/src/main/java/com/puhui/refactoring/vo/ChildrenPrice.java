package com.puhui.refactoring.vo;

/**
 * Created by wentong on 2016/5/13.
 * 儿童片价格类
 */
public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }
}
