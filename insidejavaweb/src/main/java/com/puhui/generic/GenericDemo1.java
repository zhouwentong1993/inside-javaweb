package com.puhui.generic;

/**
 * Created by wentong on 2016/7/30.
 * 泛型 demo
 */
public class GenericDemo1<T> {
    private T t;

    public GenericDemo1(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        // 声明一下这个容器里面包装的是 Automobile 这个类。
        GenericDemo1<Automobile> genericDemo1 = new GenericDemo1<>(new Automobile());
        Automobile t = genericDemo1.getT();
//        genericDemo1.setT("String");
        GenericDemo1<Father> genericDemo2 = new GenericDemo1<>(new Son());
        Father t1 = genericDemo2.getT();

    }
}

