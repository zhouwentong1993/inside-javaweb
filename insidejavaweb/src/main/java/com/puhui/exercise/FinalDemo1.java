package com.puhui.exercise;

import java.lang.reflect.Field;

/**
 * Created by wentong on 2016/7/2.
 * 关于 final 关键字
 */
public class FinalDemo1 {
    public static void main(String[] args) throws IllegalAccessException {
        final String s1 = "s1";
        String s3 = new String("s32ssz");
        String s4 = s3.replace('s', '2');
        final String s2 = s3;
        Field[] fields = s3.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ("value".equals(field.getName())) {
                field.setAccessible(true);
                field.setChar(s3,'a');
            }
        }
//        s1 = "abc";
        System.out.println(s2);
    }

}
