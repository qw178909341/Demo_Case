package com.fishs.chat3.case2.example2;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/21 15:38
 */
public class Exam1 {
    static void main()  throws  Exception{
        Person p = new Person("张三", 18);
        System.out.println(p);
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());

        }
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
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
