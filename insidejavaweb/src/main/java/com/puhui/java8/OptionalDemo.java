package com.puhui.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by wentong on 2016/4/24.
 * 可以对容器进行判断，是否为空。可以结合其他的 Function 包底下的内容做过滤。
 * 这个是初步过滤，先进行判空操作，然后进行 filter。
 */

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("abc");
        String s = optional.get();
        System.out.println(s);
        System.out.println("==============");
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        Optional<List<String>> listOptional = Optional.of(list);
        String s1 = listOptional.get().get(1);
        System.out.println(s1);
    }
}
