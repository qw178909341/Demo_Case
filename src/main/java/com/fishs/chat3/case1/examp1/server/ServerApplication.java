package com.fishs.chat3.case1.examp1.server;

import com.fishs.chat3.case1.examp1.model.Base;
import com.fishs.chat3.case1.examp1.model.Person;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/12 14:12
 */
public class ServerApplication {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 12, 89);
        Base b = new Person("Xiao Ming", 12, "Male");
        System.out.println(b);
        if (b instanceof Person person) {

            person.SayText("Hello wrold");
            person.setVersion("1.0.0");
            System.out.println(person.getVersion());
        }
        System.out.println(b instanceof Base);
        System.out.println(b instanceof Person);
    }
}

class P {
    protected String name;
    protected int age;

    public P(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public P() {
    }
}

class Student extends P {
    protected int score;

    public Student(String name, int age, int score) {
        this.score = score;
    }
}