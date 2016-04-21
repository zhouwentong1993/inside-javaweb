package com.puhui.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by wentong on 2016/4/22.
 */
public class Person {
    public enum Sex {
        MAIL, FEMAIL;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        printPersons(new ArrayList<>(), new CheckPersonEligibleForSelectiveService());
        printPersons(new ArrayList<>(), new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.gender == Sex.FEMAIL && (person.getAge() > 18 && person.getAge() < 25);
            }
        });
        printPersons(new ArrayList<>(), (Person p) -> p.gender == Sex.FEMAIL && p.getAge() > 15 && p.getAge() < 25);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public static void printPerson(List<Person> personList, int age) {
        for (Person person : personList) {
            if (person.getAge() > age) {
                System.out.println(person);
            }
        }
    }

    public static void printPersonWithRange(List<Person> personList, int low, int high) {
        for (Person person : personList) {
            if (low < person.getAge() && person.getAge() < high) {
                System.out.println(person);
            }
        }
    }

    public static void printPersons(List<Person> personList, CheckPerson tester) {
        for (Person person : personList) {
            tester.test(person);
        }
    }

    interface CheckPerson {
        boolean test(Person person);
    }

    static class CheckPersonEligibleForSelectiveService implements CheckPerson {

        @Override
        public boolean test(Person person) {
            return person.gender == Sex.FEMAIL && (person.getAge() > 18 && person.getAge() < 25);
        }

    }

    static void printPersonWithPredicate(List<Person> roster, Predicate<Person> tester){
        for (Person person : roster) {
            tester.test(person);
        }
    }

}
