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

    //考虑到这个方法是跟电影有关系的，所以需要移到电影实体类底下。
    public double getCharge() {
        double result;
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
        result = movie.getCharge(daysRented);

        return result;
    }

    // 这样不优雅，因为这个方法不是返回 1，就是返回 2
//    public int getFrequentRenterPoints() {
//        int result = 0;
//        result++;
//        // 看新片加积分
//        if (Movie.NEW_RELEASE == getMovie().getPriceCode()) {
//            result++;
//        }
//        return result;
//    }

    //用同样的手法，将 getFrequentRenterPoints() 抽取出去。
    public int getFrequentRenterPoints() {
       return movie.getFrequentRenterPoints();
    }
}
