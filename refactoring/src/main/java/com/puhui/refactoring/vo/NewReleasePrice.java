package com.puhui.refactoring.vo;

/**
 * Created by wentong on 2016/5/13.
 * 新发行片价格类
 */
public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
//        if (daysRented > 1) {
//            return 2;
//        }
//        return 1;
        return daysRented > 1 ? 2 : 1;
    }
}
