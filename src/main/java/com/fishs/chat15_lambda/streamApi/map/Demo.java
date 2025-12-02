package com.fishs.chat15_lambda.streamApi.map;

import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 10:18
 */
public class Demo {
    static void main() {
        //List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        //System.out.println(integers.stream().map(i -> i * i).toList());
        List<Person> persons = List.of(new Person("张三", 18), new Person("李四", 19), new Person("王五", 20));
        System.out.println(persons.stream().map((p) -> p.age * 10).toList());
    }
}


class Person{
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}