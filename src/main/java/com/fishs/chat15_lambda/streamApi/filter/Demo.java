package com.fishs.chat15_lambda.streamApi.filter;

import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 10:34
 */
public class Demo {
    static void main() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(integers.stream().filter(i -> i % 2 == 0).toList());
    }
}
