package com.fishs.chat15_lambda.streamApi.outArray;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 11:13
 */
public class Example
{
    @Test
    public void Test(){
        Stream<String> stringStream = Stream.of("name:zhangsan", "age:18", "address:翻斗花园");
        Map<String, String> collect = stringStream.collect(Collectors.toMap(s -> s.split(":")[0], s -> s.split(":")[1]));
        System.out.println(collect);
    }

    @Test
    public void TestGroupingBy(){
        List<String> arrays = List.of("Apple", "Banana", "Black", "Cherry", "Dog", "Elephant", "Blue", "Art");
        Map<Character, List<String>> collect = arrays.stream().collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toList()));
        System.out.println( collect);

    }
}
