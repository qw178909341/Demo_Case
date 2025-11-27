package com.fishs.chat8_collection.caseTreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 15:40
 */
public class Demo {
    public static void main(String[] args) {
        // 1. 准备测试数据（特意打乱顺序，且哈希值分布不规则）
        String[] keys = {"orange", "apple", "banana", "grape", "cherry", "date"};
        String[] values = {"橙子", "苹果", "香蕉", "葡萄", "樱桃", "枣"};

        // 2. 测试 HashMap（无序）
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], values[i]);
        }
        System.out.println("1. HashMap（无序，按哈希桶排列）:");
        System.out.println("   " + hashMap);

        // 3. 测试 TreeMap（按键自然顺序排序）
        Map<String, String> treeMap = new TreeMap<>();
        for (int i = 0; i < keys.length; i++) {
            treeMap.put(keys[i], values[i]);
        }
        System.out.println("\n2. TreeMap（按键自然顺序排序）:");
        System.out.println("   " + treeMap);

        // 4. 测试 LinkedHashMap（按插入顺序）
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            linkedHashMap.put(keys[i], values[i]);
        }
        System.out.println("\n3. LinkedHashMap（按插入顺序）:");
        System.out.println("   " + linkedHashMap);

        // 5. 额外测试：数字键的差异（更直观）
        System.out.println("\n=== 数字键测试 ===");
        Map<String, String> numHashMap = new HashMap<>();
        numHashMap.put("5", "五");
        numHashMap.put("2", "二");
        numHashMap.put("8", "八");
        numHashMap.put("1", "一");
        System.out.println("HashMap（数字键，无序）: " + numHashMap);

        Map<String, String> numTreeMap = new TreeMap<>();
        numTreeMap.put("5", "五");
        numTreeMap.put("2", "二");
        numTreeMap.put("8", "八");
        numTreeMap.put("1", "一");
        System.out.println("TreeMap（数字键，按自然顺序）: " + numTreeMap);
    }
}
@Data
@AllArgsConstructor
class Person{
    private String name;
    private Integer age;

}
