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
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
//        this.priceCode = priceCode;
        setPriceCode(priceCode);
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
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("非法的参数");
        }
        this.priceCode = priceCode;
    }

    // 1.0 将该方法放置到 Movie 实体类中，考虑到拓展性，只传递出租日期。片子的类型交给 Movie 类自己维护。
    // 2.0 将该方法放置到 Price 实体类中，
    public double getCharge(int daysRented) {
//        double result = 0.0;
//        switch (priceCode) {
//            case Movie.REGULAR: // 普通片
//                result += 2;
//                if (daysRented > 2) {
//                    result += (result - 2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += daysRented * 3;
//                break;
//            case Movie.CHILDREN:
//                result += 1.5;
//                if (daysRented > 3) {
//                    result += (daysRented - 3) * 1.5;
//                }
//                break;
//        }
//
//        return result;
        return price.getCharge(daysRented);
    }

    // 将 getFrequentRenterPoints() 方法转移到 Price 类里面去
    public int getFrequentRenterPoints(int daysRented) {
//        if (Movie.NEW_RELEASE == priceCode && daysRented > 1) {
//            return 2;
//        }
//        return 1;
        return price.getFrequentRenterPoints(daysRented);
    }
}
