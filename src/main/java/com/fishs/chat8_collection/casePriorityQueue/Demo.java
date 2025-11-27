package com.fishs.chat8_collection.casePriorityQueue;

import com.fishs.chat3.case2.example3.User;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 16:24
 */
public class Demo {
    // 优先级的队列
    static void main() {
        // 优先级队列：V开头元素优先，同前缀按第二个字符升序
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            // 正则匹配前缀（字母）和后缀（数字）
            private final Pattern pattern = Pattern.compile("([A-Za-z]+)(\\d+)");

            @Override
            public int compare(String o1, String o2) {
                // 1. 先比较前缀优先级：V开头 > A开头
                String prefix1 = getPrefix(o1);
                String prefix2 = getPrefix(o2);

                if ("V".equals(prefix1) && !"V".equals(prefix2)) {
                    return -1; // V前缀优先级更高
                } else if (!"V".equals(prefix1) && "V".equals(prefix2)) {
                    return 1;
                }

                // 2. 前缀相同，按后缀数字大小排序
                int num1 = getNumberSuffix(o1);
                int num2 = getNumberSuffix(o2);
                return Integer.compare(num1, num2);
            }

            // 提取前缀（字母部分）
            private String getPrefix(String s) {
                Matcher matcher = pattern.matcher(s);
                return matcher.find() ? matcher.group(1) : s;
            }

            // 提取后缀数字（支持多位数）
            private int getNumberSuffix(String s) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    return Integer.parseInt(matcher.group(2));
                }
                return 0; // 无数字后缀时返回0
            }
        });
        queue.add("A1");
        queue.add("A2");
        queue.add("A3");
        queue.add("A4222");
        queue.add("V1");
        queue.add("V25");
        queue.add("V322");
        queue.add("V4");
        queue.add("A5");
        queue.add("A655");
        queue.add("V5");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
