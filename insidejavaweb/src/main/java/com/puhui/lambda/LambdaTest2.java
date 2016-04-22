package com.puhui.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wentong on 2016/4/22.
 */
public class LambdaTest2 {

    public static void main(String[] args) {
        runThread();
    }

    public static void runThread() {
        new Thread(() -> {
            System.out.println("Hello World!");
        }).start();
    }

    public static void testSort() {
        List<Integer> list = new ArrayList<>();
        // 这里会进行类型方法自动推导，这个 sort 方法会有两个参数，第二个是一个 Comparator 接口
        // 由于是实现方法，所以形式参数的类型不能发生变化，或者说这是固定的。这里我们相当于重写了这个方法
        // 方法的参数是 Object 类型的 o1 和 o2，方法的返回值是 o2 - o1 的值。
        Collections.sort(list, (o1, o2) -> o2 - o1);
    }

}
