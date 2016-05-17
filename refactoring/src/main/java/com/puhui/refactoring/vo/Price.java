package com.puhui.refactoring.vo;

/**
 * Created by wentong on 2016/5/13.
 * 价格抽象类
 */
public abstract class Price {

    abstract int getPriceCode();

    // 将 getCharge(int daysRented)的具体实现拆分到每一个子类中去，让子类实现代码。
    // 面向接口编程，以后只需要跟 Price 的 getCharge 方法进行交互就行了。
    abstract double getCharge(int daysRented);
//        double result = 0.0;
//        switch (getPriceCode()) {
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
//    }

    // 这个方法写的时候要考虑了，因为这个方法只是跟 NEW_RELEASE 这种类型的影片有关
    // 所以不需要将其声明成抽象的，应该给他声明一个默认行为，就是返回 1
    // 如果是 NEW_RELEASE 的话，就走的是实现类（NewReleasePrice）的这个方法
    // 很好的使用了多态的概念。
    public int getFrequentRenterPoints(int daysRented) {
//        if (Movie.NEW_RELEASE == getPriceCode() && daysRented > 1) {
//            return 2;
//        }
        return 1;
    }
}
