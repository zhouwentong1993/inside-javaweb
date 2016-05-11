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

    // 将临时变量替换为查询，因为临时变量容易被跟丢。
    // 现在将 thisAmount 替换为查询，虽然这样丢失了一部分性能，但是不容易犯错。
    public String statement() {
        double totalAmount = 0;
        int frequentREnterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
//            double thisAmount = 0;
//            thisAmount += rental.getCharge(rental);
            // 将计算积分方法抽取到 Rental 类中
            frequentREnterPoints += rental.getFrequentRenterPoints();

            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge(rental) + "\n";
            totalAmount += rental.getCharge(rental);
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentREnterPoints + " frequent renter points";
        return result;
    }


    // 第一步，将 switch 语句抽取出去
    // 第二步，将命名规范
    // 第三步，因为这个方法跟 Customer 这个类没有任何关系，只是跟 Rental 这个类有关，所以移走。
//    public double amountFor(Rental rental) {
//        double result = 0.0;
//        switch (rental.getMovie().getPriceCode()) {
//            case Movie.REGULAR: // 普通片
//                result += 2;
//                if (rental.getDaysRented() > 2) {
//                    result += (result - 2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += rental.getDaysRented() * 3;
//                break;
//            case Movie.CHILDREN:
//                result += 1.5;
//                if (rental.getDaysRented() > 3) {
//                    result += (rental.getDaysRented() - 3) * 1.5;
//                }
//                break;
//        }
//
//        return result;
//    }

}
