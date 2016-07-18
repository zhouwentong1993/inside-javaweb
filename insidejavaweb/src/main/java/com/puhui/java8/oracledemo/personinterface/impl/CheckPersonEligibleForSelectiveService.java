package com.puhui.java8.oracledemo.personinterface.impl;

import com.puhui.java8.oracledemo.personinterface.CheckPerson;
import com.puhui.java8.oracledemo.vo.Person;

/**
 * Created by puhui on 2016/7/18.
 * 检验用户的姓名和年龄
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson {

    @Override
    public boolean test(Person person) {
        return person.gender == Person.Sex.MALE
                && person.getAge() > 18
                && person.getAge() < 25;
    }

}
