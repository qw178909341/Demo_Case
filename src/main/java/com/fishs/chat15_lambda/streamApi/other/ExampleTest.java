package com.fishs.chat15_lambda.streamApi.other;

import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 11:23
 */
public class ExampleTest {
    @Test
    public void Test(){
        List<Integer> integers = List.of(1, 2, 3, 4654, 6, 7, 2, 3, 4, 6, 7, 99, 2, 1, 3);
        System.out.println("排序 :" + integers.stream().sorted().toList());  // 排序
        System.out.println("去重 :" + integers.stream().distinct().toList()); // 去重
        System.out.println("截取两个跳过三个 :" + integers.stream().skip(2).limit(3).toList()); // 去重
    }

    @Test
    public void TestConcat(){
        List<String> charArrays = List.of("A", "B", "C");
        List<Integer> intArrays = List.of(1, 2, 3, 4, 5, 6);
        List<? extends Serializable> list = Stream.concat(charArrays.stream(), intArrays.stream()).toList();
        System.out.println( list);
    }

    @Test
    public void TestFlatMap(){
        Stream<List<Integer>> list = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        System.out.println(list.flatMap(integers -> integers.stream()).toList());
    }

    @Test
    public void TestParallel(){

    }
}
