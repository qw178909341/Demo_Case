package com.fishs.chat8_collection.caseEnumMap;

import java.util.EnumMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 15:36
 */
public class Demo {
    public static void main(String[] args) {
        Map<Color,String> enumMap =new EnumMap<>(Color.class);
        enumMap.put(Color.RED,"红色");
        enumMap.put(Color.GREEN,"绿色");
        enumMap.put(Color.BLUE,"黄色");
        System.out.println(enumMap.get(Color.RED));
    }
}

enum Color {
    RED, GREEN, BLUE
}
