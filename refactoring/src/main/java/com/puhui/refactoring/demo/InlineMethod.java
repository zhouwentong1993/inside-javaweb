package com.puhui.refactoring.demo;

/**
 * Created by wentong on 2016/5/24.
 * 内联函数
 * 一个函数的本体与名称同样清楚易懂
 * 在函数调用点插入函数本体，然后移除该函数
 * IntelliJ IDEA 做了很好的支持 快捷键 Ctrl + alt + N
 */
public class InlineMethod {
    private int numberOfLateDeliveries;

    private int getRating() {
//        return (moreThanFiveLateDeliveries() ? 2 : 1);
        // 不必要的函数抽取。
        return (numberOfLateDeliveries > 5 ? 2 : 1);
    }


    // 将该段代码注释掉
//    private boolean moreThanFiveLateDeliveries() {
//        return numberOfLateDeliveries > 5;
//    }
}
