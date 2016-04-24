package com.puhui.java8;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by wentong on 2016/4/24.
 * Java 8 的时间类
 */
public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate + " " + localTime);
    }
}
