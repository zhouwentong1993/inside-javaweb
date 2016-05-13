package com.puhui.refactoring.vo;

/**
 * Created by wentong on 2016/5/13.
 */
public abstract class Price {
    abstract int getPriceCode();

    public double getCharge(int daysRented) {
        double result = 0.0;
        switch (getPriceCode()) {
            case Movie.REGULAR: // 普通片
                result += 2;
                if (daysRented > 2) {
                    result += (result - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }

        return result;
    }
}
