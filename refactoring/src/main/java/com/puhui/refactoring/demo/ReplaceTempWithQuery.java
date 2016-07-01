package com.puhui.refactoring.demo;

/**
 * Created by wentong on 2016/7/1.
 * 以查询取代临时变量
 * 首先要先将临时变量声明为 final 类型，这样可以检测该变量是否是唯一被当前所使用的， 如果不是，先将这个变量替换成
 * 唯一使用的变量。
 * 然后提炼等号右边的代码，抽取出来，然后将所有引用原来变量的代码都换成这个转换之后的函数。
 */
public class ReplaceTempWithQuery {

    int quantity = 100;
    int itemPrice = 50;


    public double test1() {
        double basePrice = quantity * itemPrice;
        if (basePrice > 1000) {
            return basePrice * 0.95;
        } else {
            return basePrice * 0.98;
        }
    }

    public double test2() {
        if (basePrice() > 1000) {
            return basePrice() * 0.95;
        } else {
            return basePrice() * 0.98;
        }
    }

    private double basePrice() {
        return quantity * itemPrice;
    }
}
