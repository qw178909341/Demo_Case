package com.fishs.chat15_lambda.stream;

import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/1 17:36
 */
public class Demo {
    static void main() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream().forEach(System.out::println);
    }
}
