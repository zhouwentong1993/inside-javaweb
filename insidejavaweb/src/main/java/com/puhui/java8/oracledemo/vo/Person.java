package com.puhui.java8.oracledemo.vo;

import java.time.LocalDate;

/**
 * Created by puhui on 2016/7/18.
 * Oracle 官方的例子，Person 实体类
 */
public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    public Sex gender;
    String emailAddress;
    Integer age;

    public int getAge() {
        return this.age;
    }

    public void printPerson() {
        System.out.println("Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                ", age=" + age +
                '}');
    }

}
