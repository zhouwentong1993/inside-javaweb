package com.puhui.refactoring.demo;

/**
 * Created by wentong on 2016/7/3.
 * 移除对参数的赋值
 */
public class RemoveAssignments2Parameters {
    int discount(int inputVal, int quantity, int yearToDate) {
        if (inputVal > 50) {
            inputVal -= 2;
        }
        if (quantity > 100) {
            inputVal -= 1;
        }
        if (yearToDate > 10000) {
            inputVal -= 4;
        }
        return inputVal;
    }


    /**
     * 将要改变的变量用临时变量替换，更狠一点的方法就是在传入参数处加上 final 关键字，这样就能保证
     * 传入参数不被修改了。
     * @param inputVal 输入的值
     * @param quantity 数量
     * @param yearToDate 年份
     * @return 结果
     */
    int discount2(int inputVal, int quantity, int yearToDate) {
        int result = inputVal;
        if (inputVal > 50) {
            result -= 2;
        }
        if (quantity > 100) {
            result -= 1;
        }
        if (yearToDate > 10000) {
            result -= 4;
        }
        return result;
    }
}
