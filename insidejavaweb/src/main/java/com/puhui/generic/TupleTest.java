package com.puhui.generic;

/**
 * Created by wentong on 2016/7/30.
 * 元组测试类
 */
public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("First", 103);
    }

    static TwoTuple<Amphibian, Vehicle> g() {
        return new TwoTuple<>(new Amphibian("aaa", "bbb"), new Vehicle());
    }


    public static void main(String[] args) {
        System.out.println(f());
        TwoTuple<Amphibian, Vehicle> g = g();
        g.first.first = "abcd";
        System.out.println(g);
    }
}

class Amphibian {
    String first;
    String second;

    public Amphibian(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Amphibian{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}

class Vehicle {
}
