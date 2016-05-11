package com.puhui.refactoring.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wentong on 2016/5/11.
 * 顾客实体类
 */
public class Customer {
    private String name; // 用户姓名
    private List<Rental> rentals = new ArrayList<>(); // 租赁列表

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentREnterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double thisAmount = 0;
            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR: // 普通片
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2) {
                        thisAmount += (thisAmount - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3) {
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            frequentREnterPoints++;
            // 看新片有优惠
            if (Movie.NEW_RELEASE == rental.getMovie().getPriceCode()) {
                frequentREnterPoints++;
            }

            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentREnterPoints + " frequent renter points";
        return result;
    }
}
