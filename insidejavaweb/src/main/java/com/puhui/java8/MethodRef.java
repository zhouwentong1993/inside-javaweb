package com.puhui.java8;

import java.util.Arrays;

/**
 * Created by wentong on 2016/4/24.
 * 方法引用，同样是基于推断的。
 * 这个方法会省略方法的参数，因为根据推测，他会将自己的参数直接放到匹配的方法里面去
 * 方法会自动识别这个类，注意参数一定要匹配或者是参数的超类。这样使得代码更加紧凑。
 * 我感觉 Java 8 主要是省略一切能够省略的东西，都是基于推断。
 */
public class MethodRef {
    public static void main(String[] args) {
        String[] s = {"aaa","ddd","ccc","bbb",};
        Arrays.asList(s).forEach(new MethodRef()::show);
    }

    public void show(Object s) {
        System.out.println(s);
    }
}
