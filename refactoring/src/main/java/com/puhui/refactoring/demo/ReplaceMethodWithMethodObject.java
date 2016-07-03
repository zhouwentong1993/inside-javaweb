package com.puhui.refactoring.demo;

/**
 * Created by wentong on 2016/7/3.
 * 以函数对象取代函数
 * 如果你在使用 Extract Method 时因为过多的局部变量而提取失败的话，可以使用这个方法
 * 将这个函数放入一个单独的对象中，
 * 1. 将所有的变量（包括成员变量和临时变量）都放到独立的对象的成员变量里面去。
 * 2. 将原对象作为参数传递过去，因为有可能要重构的方法调用了原对象的方法，所以需要引用做调用。
 * 这样局部变量就成为了成员变量，于是就可以直接操作成员变量了。
 */

public class ReplaceMethodWithMethodObject {
    int gamma(int inputVal, int quantity, int yearToDate) {
//        int importantValue1 = (inputVal * quantity) + delta();
//        int importantValue2 = (inputVal * yearToDate) + 100;
//        if ((yearToDate - importantValue1) > 100) {
//            importantValue2 = 20;
//        }
//        int importValue3 = importantValue2 * 7;
//        // and so on
//        return importValue3 - 2 * importantValue1;
        return new Gamma(this, inputVal, quantity, yearToDate).compute();
    }

    public int delta() {
        return 0;
    }
}

class Gamma {
    private final ReplaceMethodWithMethodObject replaceMethodWithMethodObject;
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;

    public Gamma(ReplaceMethodWithMethodObject replaceMethodWithMethodObject,
                 int inputVal, int quantity, int yearToDate) {
        this.replaceMethodWithMethodObject = replaceMethodWithMethodObject;
        this.inputVal = inputVal;
        this.quantity = quantity;
        this.yearToDate = yearToDate;
    }

    public int compute() {
        int importantValue1 = (inputVal * quantity) + replaceMethodWithMethodObject.delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        // 这里就可以将方法抽取出来了。
//        if ((yearToDate - importantValue1) > 100) {
//            importantValue2 = 20;
//        }
        importThing();
        int importValue3 = importantValue2 * 7;
        // and so on
        return importValue3 - 2 * importantValue1;
    }

    private void importThing() {
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 = 20;
        }
    }
}
