package com.puhui.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * Created by wentong on 2016/4/22.
 */
public class CollectionUtils {
    public static List map(List<String> input, Function processor) {
        List<Object> list = new ArrayList<>();
        for (String t : input) {
            list.add(processor.apply(t));
        }
        return list;
    }

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("Jack");
        list.add("Jack1");
        list.add("Jack11");
        list.add("Jack2");
        list.add("Jack333");
        List list1 = map(list, (String s) -> s.length());
        List uppercases = CollectionUtils.map(list, (String v) -> v.toUpperCase());
    }
    Collection
}
