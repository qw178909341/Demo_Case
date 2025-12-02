package com.fishs.chat12_thread.caseThreadLocal;

import java.util.HashMap;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/1 13:49
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        new Thread(()->{
           threadLocal.set("hello world");
        });
        //Thread.sleep(1000);
        //threadLocal.set("hello world");
        System.out.println(threadLocal.get());
    }
}
