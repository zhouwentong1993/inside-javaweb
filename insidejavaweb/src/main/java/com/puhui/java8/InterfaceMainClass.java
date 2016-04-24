package com.puhui.java8;

/**
 * Created by wentong on 2016/4/24.
 */
public class InterfaceMainClass implements InterfaceDefaultMethod{
    public static void main(String[] args) {
        InterfaceDefaultMethod.showStatic("static");
        InterfaceDefaultMethod interfaceMainClass = new InterfaceMainClass();
        interfaceMainClass.showDefault("default");
        interfaceMainClass.show("mainClass");
    }

    @Override
    public void showDefault(String defaultName) {
        System.out.println("This is InterfaceMainClass : " + defaultName);
    }

    @Override
    public void show(String name) {
        System.out.println("This is InterfaceMainClass : " + name);
    }
}
