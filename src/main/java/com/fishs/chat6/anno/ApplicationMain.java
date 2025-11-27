package com.fishs.chat6.anno;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/24 17:26
 */
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        Person p = new Person(5,"张三",  Arrays.asList("唱", "跳", "rap"));
        Class<? extends Person> aClass = p.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Check annotation = declaredField.getAnnotation(Check.class);
            Range range = declaredField.getAnnotation(Range.class);
            Object o = declaredField.get(p);
            if (annotation != null) {
                int value = annotation.value();
                if (o instanceof Integer) {
                    if (value > 0 && (Integer) o < value) {
                        System.out.println("年龄不能小于" + value);
                    }
                }
            }
            if (range != null) {
                if (o instanceof String s) {
                    System.out.println(o.toString() + "长度为:" + s.length());
                }
                if (o instanceof List aList ) {

                    System.out.println(o + "长度为:" + aList.size() );
                }
            }
        }

    }
}


class  Person{
    @Check(10)
    @Range
    private Integer age;
    public void setAge(Integer age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public Person() {
    }
    @Range
    private List<String> hobby;
    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }
    public List<String> getHobby() {
        return hobby;
    }
    @Range
    private String name ;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Person(Integer age, String name, List<String> hobby) {
        this.age = age;
        this.name = name;
        this.hobby = hobby;
    }
}