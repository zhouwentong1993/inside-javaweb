package com.puhui.aboutNull;

import java.util.Comparator;

/**
 * Created by wentong on 2016/7/30.
 * 关于 null
 */
public class NullDemo {
    public static void main(String[] args) {
        Comparator<Integer> naturalOrder = new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return first < second ? -1 : (first == second ? 0 : 1);
            }
        };

        Integer temp = new Integer(null);
        Integer temp1 = null;
        Integer integer = null;
        System.out.println(integer);
        int compare2 = naturalOrder.compare(1111, 1111);
        int compare1 = naturalOrder.compare(new Integer(1), new Integer(1));
        int compare =  naturalOrder.compare(null, null);
        System.out.println(compare);
        System.out.println(compare1);
        System.out.println(compare2);
    }
}
