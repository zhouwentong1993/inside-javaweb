package com.puhui.string;

/**
 * Created by wentong on 2016/7/30.
 * 关于 String 的相关内容
 */
public class StringDemo {
    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("select * from xxx where 1=1");
            sb.append("and id = ? and name = ?");
            sb.append("order by name desc");
            String sql1 = sb.toString();
        }
        System.out.println("StringBuilder = " + (System.nanoTime() - start));

        long start1 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            String sql = "select * from xxx where 1=1" + "and id = ? and name = ?" + "order by name desc";
        }
        System.out.println("String = " + (System.nanoTime() - start1));
    }
}
