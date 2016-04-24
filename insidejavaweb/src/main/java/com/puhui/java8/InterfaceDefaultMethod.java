package com.puhui.java8;

/**
 * Created by wentong on 2016/4/24.
 */
public interface InterfaceDefaultMethod {
    /**
     * 抽象方法
     * @param name 抽象名称
     */
    void show(String name);

    /**
     * 默认方法
     * @param defaultName 默认名称
     */
    default void showDefault(String defaultName) {
        System.out.println("This is default method: " + defaultName);
    }

    /**
     * 静态方法
     * @param staticName 静态名称
     */
    static void showStatic(String staticName) {
        System.out.println("This is static method : " + staticName);
    }
}
