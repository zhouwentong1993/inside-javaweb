package com.puhui.refactoring.demo;

import com.puhui.refactoring.demo.vo.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wentong on 2016/5/17.
 * 提炼函数。重构最常用的方法。
 *
 * 提炼函数分为三种情况：
 * 1.
 */
public class ExtractMethod {

    private final List<Order> orders = new ArrayList<>();

    public void printOwing() {
        double outstanding = 0.0;
        getData();
        printBanner();
        printDetails(getOutstanding());
    }

    // 将组织参数的代码提取出来
    private void getData() {
        orders.add(new Order(10));
        orders.add(new Order(60));
        orders.add(new Order(50));
        orders.add(new Order(40));
        orders.add(new Order(30));
        orders.add(new Order(20));
    }

    // step 1 这种代码可以直接复制剪切就行。
    private void printBanner() {
        //print banner
        System.out.println("*******************************");
        System.out.println("******* Customer owes *********");
        System.out.println("*******************************");
    }

    // step 2 这种带有一个参数，需要将这个参数传递进来。
    private void printDetails(double outstanding) {
        String name = "Jack";
        System.out.println("name: " + name);
        System.out.println("amount:" + outstanding);
    }

    // step 3 在本例中的 outstanding 只是被初始化成一个明确地初始值，所以可以在新函数中对其进行初始化
    // 这里直接将 result 声明成了 0.0。
    private double getOutstanding() {
        double result = 0.0;
        for (Order order : orders) {
            result += order.getAmount();
        }
        return result;
    }
}
