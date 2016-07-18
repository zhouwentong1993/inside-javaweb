package com.puhui.java8.oracledemo;

import com.puhui.java8.oracledemo.personinterface.CheckPerson;
import com.puhui.java8.oracledemo.personinterface.impl.CheckPersonEligibleForSelectiveService;
import com.puhui.java8.oracledemo.vo.Person;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by puhui on 2016/7/18.
 * Lambda 表达式 demo
 */
public class LambdaDemo {

    /**
     * 根据年龄来判断是否需要打印
     * @param roster Person 集合
     * @param age 指定年龄
     */
    public static void printPersonsWithinAgeRange(List<Person> roster, int age) {
        for (Person person : roster) {
            if (person.getAge() > age) {
                person.printPerson();
            }
        }
    }

    /**
     * 根据年龄来打印用户，有上下限
     * @param roster 用户集合
     * @param low 下限
     * @param high 上限
     */
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person person : roster) {
            if (person.getAge() > low && person.getAge() < high) {
                person.printPerson();
            }
        }
    }

    /**
     * 通过实现接口，重写方法的方式来实现筛选
     * @param roster Person 集合
     */
    public static void printPersons(List<Person> roster) {
        CheckPersonEligibleForSelectiveService checkPerson = new CheckPersonEligibleForSelectiveService();
        for (Person person : roster) {
            if (checkPerson.test(person)) {
                person.printPerson();
            }
        }
    }

    /**
     * 通过使用匿名内部类实现过滤
     * @param roster Person 集合
     */
    public static void printPersons1(List<Person> roster) {
        new CheckPerson(){
            @Override
            public boolean test(Person person) {
                return person.gender == Person.Sex.MALE
                        && person.getAge() > 18
                        && person.getAge() < 25;
            }
        };
    }

    /**
     * 通过使用 Predicate 的 test 方法来实现过滤
     * @param roster Person 集合
     * @param tester Predicate
     */
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person person : roster) {
            if (tester.test(person)) {
                person.printPerson();
            }
        }
    }

}
