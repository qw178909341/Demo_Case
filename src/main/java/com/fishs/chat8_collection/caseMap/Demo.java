package com.fishs.chat8_collection.caseMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 14:24
 */
public class Demo {
    public static void main(String[] args) {
        Map<String, StudentDemo> map  =Map.of(
                "1",new StudentDemo("张三"),
                "2",new StudentDemo("李四")
        );
        System.out.println(map.get("1"));
        map.forEach((k,v) -> System.out.println(k + ":" + v));
    }
}
class StudentDemo{
    private String name;

    public StudentDemo(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
