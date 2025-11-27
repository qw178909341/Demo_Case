package com.fishs.chat8_collection.caseList.equals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 13:48
 */
public class StudyCase {
    // list中要重写equals方法，基础的包装类已经实现了equals方法，可以比较查询，但是自定义的类型是没有重新equals的
    public static void main(String[] args) {
        handlerCaseDemo2();
    }

    // 底层已经实现了equals,比较的是值
    public static void handlerCaseDemo1() {
        List<String> list = Arrays.asList("张三", "李四", "王五");
        System.out.println(list.contains("张三"));  // true
        System.out.println(list.contains(new String("张三"))); // true
    }

    // 重写equals
    public static void handlerCaseDemo2() {
        List<Person> p = new ArrayList<>();
        p.add(new Person("张三"));
        System.out.println(p.contains(new Person("张三"))); // false
    }

}

class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }

    // 重写equals，如果实例类型属于Person才比较name是否一致，否则返回false
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person person) {
            return this.name.equals(person.name);
        }
        return false;
    }
}