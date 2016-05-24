package com.puhui.refactoring.demo.vo;

/**
 * Created by wentong on 2016/5/24.
 */
public class Order {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Order(double amount) {
        this.amount = amount;
    }
}
