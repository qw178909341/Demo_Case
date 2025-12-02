package com.fishs.chat15_lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/1 17:50
 */
public class Example {
    static void main() {
         //LongStream.generate(new Fibonacci()).limit(50).forEach(System.out::println);
        List<String> names = List.of("张三", "李四", "王五");
        Stream<Person> personStream = names.stream().map(Person::new);
        System.out.println(personStream.toList());
        personStream.forEach(System.out::println);
        System.out.println(personStream.toList());
    }

}

class Fibonacci implements LongSupplier {
    private final List<Long> cache = new ArrayList<>(); // 缓存已生成的斐波那契数
    // 初始化缓存：存入前两个基础值（斐波那契数列起始）
    private long prev = 0L;
    private long curr = 1L;

    public Fibonacci() {
        // 初始化缓存，存入前两个数（0和1），避免重复计算
        cache.add(prev); // cache[0] = 0
        cache.add(curr); // cache[1] = 1
    }

    /**
     * 核心方法：获取第n个斐波那契数（n从0开始）
     * 已缓存则直接返回，未缓存则计算并追加到缓存
     */
    public long getFibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("索引不能为负数");

        // 若n已在缓存中，直接返回（无需计算，快速查询）
        if (n < cache.size()) {
            return cache.get(n);
        }

        // 若n超出缓存，仅计算从缓存末尾到n的部分（增量计算，避免重复）
        long lastPrev = cache.get(cache.size() - 2); // 缓存最后两个数
        long lastCurr = cache.get(cache.size() - 1);

        for (int i = cache.size(); i <= n; i++) {
            long next = lastPrev + lastCurr;
            cache.add(next); // 新数存入缓存
            // 更新指针，准备下一个计算
            lastPrev = lastCurr;
            lastCurr = next;
        }

        return cache.get(n);
    }

    /**
     * 实现LongSupplier接口，供Stream生成使用（复用getFibonacci逻辑）
     */
    @Override
    public long getAsLong() {
        // 每次调用返回当前缓存的下一个数（自动扩容缓存）
        return getFibonacci(cache.size());
    }
}


class Person{
    String name;
    public Person(String name){
        this.name = name;
    }
    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}