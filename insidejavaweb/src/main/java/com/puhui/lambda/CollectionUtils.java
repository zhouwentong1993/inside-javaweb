package com.puhui.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by wentong on 2016/4/22.
 */
public class CollectionUtils {
    private static String[] players = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka", "David Ferrer",
            "Roger Federer", "Andy Murray",
            "Tomas Berdych", "Juan Martin Del Potro",
            "Richard Gasquet", "John Isner"};

    private static Predicate<Person> ageFilter = (p) -> p.getAge() > 25;
    private static Predicate<Person> salaryFilter = (p) -> p.getSalary() > 3500;
    private static Predicate<Person> sexFilter = p -> Objects.equals(p.getGender(), "male");
    private static List<Person> javaProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
            add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
            add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
            add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
            add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
            add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
            add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
            add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
            add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
            add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
        }
    };

    private static List<Person> phpProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 500000));
            add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
            add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 500000));
            add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
            add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 50000));
            add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
            add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 115500));
            add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
            add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 160550));
            add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
        }
    };

    public static List map(List<String> input, Function<String, Object> processor) {
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
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));

        System.out.println("=============================");
        System.out.println("输出所有程序员的名称");
        javaProgrammers.forEach((p) -> System.out.println("Java: " + p.getFirstName() + " : " + p.getLastName()));
        phpProgrammers.forEach((p) -> System.out.println("PHP: " + p.getFirstName() + " : " + p.getLastName()));
        System.out.println("================================");
        System.out.println("给所有程序员加薪");
        Consumer<Person> consumer = e -> e.setSalary(e.getSalary() * 100 / 50 + e.getSalary());
        javaProgrammers.forEach(consumer);
        phpProgrammers.forEach(consumer);
        System.out.println("加薪完成，加薪之后的薪水为");
        javaProgrammers.forEach((p) -> System.out.print(p.getSalary() + "  "));
        System.out.println();
        phpProgrammers.forEach((p) -> System.out.print(p.getSalary() + "  "));
        System.out.println();
        System.out.println("====================================");
        System.out.println("PHP 程序员工资超过 3500 的有");
        phpProgrammers.stream().filter((p) -> p.getSalary() > 3500).forEach((p) -> System.out.print(p.getFirstName() + "  "));
        System.out.println();
        System.out.println("=====================================");
        phpProgrammers.stream()
                .filter(ageFilter).filter(salaryFilter).filter(sexFilter).limit(3).forEach(p -> System.out.print(p.getFirstName() + "  "));
        System.out.println();
        System.out.println("===================================");
        javaProgrammers.stream().filter(salaryFilter).filter(ageFilter).sorted((p1, p2) -> (p1.getSalary() - p2.getSalary())).forEach(p -> System.out.println(p.getFirstName() + " salary : " + p.getSalary() + "    "));
        System.out.println();
        System.out.println("=============================");
        javaProgrammers.stream().sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName())).limit(3).forEach(p -> System.out.print(p.getFirstName() + "  "));
        System.out.println();
        System.out.println("=============================");
        javaProgrammers.stream().sorted((p1, p2) -> p1.getSalary() - p2.getSalary()).limit(javaProgrammers.size() - 1).forEach(p -> System.out.print(p.getSalary() + "  "));
        System.out.println();
        System.out.println("=============================");
        Person personMin = javaProgrammers.stream().min((p1, p2) -> p1.getSalary() - p2.getSalary()).get();
        System.out.println("收入最少的：" + personMin.getFirstName());
        Person personMax = javaProgrammers.stream().max((p1, p2) -> p1.getSalary() - p2.getSalary()).get();
        System.out.println("收入最多的：" + personMax.getFirstName());
    }
}
