package com.company;

import java.util.List;

public class Student {
    private int age;
    private String name;

    private static int count;
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Student.count = count;
    }


    static {
        count = 0;
    }


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}