package com.fishs.chat8_collection.caseList.equals;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 14:04
 */
public class Example {
    // 给Person类增加equals方法，使得调用indexOf()方法返回正常：
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("张三"), new Person("李四"), new Person("王五"));
        System.out.println(list.indexOf(new Person("李四")));
    }


}
