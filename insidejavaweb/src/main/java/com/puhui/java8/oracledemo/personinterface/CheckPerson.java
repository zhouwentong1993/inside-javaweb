package com.puhui.java8.oracledemo.personinterface;

import com.puhui.java8.oracledemo.vo.Person;

/**
 * Created by puhui on 2016/7/18.
 * 检查 Person 合法性接口，通过实现该接口来实现所需要的功能
 */
public interface CheckPerson {
    boolean test(Person person);
}
