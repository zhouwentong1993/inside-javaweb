package com.puhui.refactoring.demo;

/**
 * Created by wentong on 2016/5/24.
 * 內建临时变量
 * 你有一个临时变量，只被一个简单表达式赋值一次，而他妨碍了其他重构手法
 * 将所有对该变量的引用动作，替换为对他赋值的那个表达式自身
 */
public class InlineTemp {
    private boolean checkPrice() {
        // 不需要有临时变量。直接用方法就行
//        double v = basePrice();
//        return v > 100;
        return basePrice() > 100;
    }

    private double basePrice() {
        // 返回一个值
        return 0.0;
    }
}
