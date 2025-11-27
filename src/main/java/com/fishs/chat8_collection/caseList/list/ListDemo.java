package com.fishs.chat8_collection.caseList.list;

import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 11:48
 */
public class ListDemo {

    public static void main(String[] args) {
        //handler1();
        handler2();

    }
    // 三种循环 完全一样
    public static void handler1(){
        List<Integer> list = List.of(1, 2, 5);
        // 1.java的语法糖 跟2是一样的
        for (Integer integer : list) {
            System.out.println(integer);
        }
        // 2 迭代器
        for( Iterator<Integer> it = list.iterator();it.hasNext();){
            System.out.println(it.next());
        }
        // 3 迭代器 跟2其实一样，只是一个是for 一个是while
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }

    // List转Array
    public static void handler2(){
        List<Integer> list = List.of(1, 2, 5);
        //Integer[] array = list.toArray(Integer[]::new); // 函数式写法
        Integer[] array = list.toArray(new Integer[0]);  // 这里给0代表初始化大小为0，会自动扩容。也可以给一个list.size()
        System.out.println( array.length);
    }

}
