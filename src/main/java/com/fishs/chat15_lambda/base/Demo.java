package com.fishs.chat15_lambda.base;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/1 17:20
 */
public class Demo {
    static void main() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Person> collect = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println( collect);
    }
}

class Person{
    String name;
    public Person(String  name){
        this.name = name;
    }
    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}