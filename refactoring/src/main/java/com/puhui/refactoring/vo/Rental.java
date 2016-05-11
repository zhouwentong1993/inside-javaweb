package com.puhui.refactoring.vo;

/**
 * Created by wentong on 2016/5/11.
 * 租赁实体类
 */
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    public double getCharge(Rental rental) {
        double result = 0.0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR: // 普通片
                result += 2;
                if (rental.getDaysRented() > 2) {
                    result += (result - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (rental.getDaysRented() > 3) {
                    result += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }

        return result;
    }
}
