package com.fishs.chat12_thread.caseVirtualThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/1 14:15
 */
public class Demo {
    final static ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
    //static final ExecutorService executor = Executors.newFixedThreadPool(1000);
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10000; i++) {
            int n = i;

            executor.submit(() -> {
                System.out.println("Task=" + n + " -> " + Thread.currentThread());
                Thread.sleep(1000);
                return n;
            });
        }

        Thread.sleep(2000);
    }
}
