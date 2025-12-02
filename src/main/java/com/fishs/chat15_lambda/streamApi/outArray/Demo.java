package com.fishs.chat15_lambda.streamApi.outArray;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Description: 输出集合
 * @Author: lf
 * @Date: 2025/12/2 10:59
 */
public class Demo
{
    static void main() {
        Stream<String> stringStream = Stream.of("1", "2", "DDee", "erer", "3", "eewds");
        System.out.println(stringStream.filter(Demo::isNumericStr).toList());
    }

    public static boolean isNumericStr(String str) {
        // 先判断 null 或空字符串
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            // 尝试转换为 double，若不抛异常则为数值
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            // 转换失败，不是数值
            return false;
        }
    }
}
