package com.fishs.chat5.case1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/24 15:21
 */
public class ExampleApp
{
    public static void main(String[] args) throws Exception{
        Person p = new Person("Xiao Ming", 12);
        Class cls = p.getClass();
        //printClassInfo(cls);
        Method setName = cls.getDeclaredMethod("setName", String.class);
        setName.setAccessible(true);
        setName.invoke(p, "Xiao Hong");
        System.out.println(p.toString());
        Method sayHello = ExampleApp.class.getMethod("sayHello", String.class);
        sayHello.invoke(null, "Xiao Ming");
    }

    public static void sayHello(String name){
        System.out.println("Hello " + name);
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Person() {
    }
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
