package com.fishs.chat12_thread.caseFuture;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    @Test
    public void Test() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 启动两个任务
        Future<Integer> f1 = executorService.submit(new AddThread());
        Future<Integer> f2 = executorService.submit(new DesThread());

        // 等待计算结束（注意：任务内部循环10000次）
        Integer addResult = f1.get();
        Integer decResult = f2.get();

        System.out.println("AddThread result = " + addResult);
        System.out.println("DesThread result = " + decResult);
        System.out.println("Final Counter = " + Counter.count.get());

        executorService.shutdown();
    }
}

class Counter {
    public static AtomicInteger count = new AtomicInteger(0);

    public static int add() {
        return count.incrementAndGet();
    }

    public static int dec() {
        return count.decrementAndGet();
    }
}

class AddThread implements Callable<Integer> {
    @Override
    public Integer call() {
        for (int i = 0; i < 10000; i++) {
            Counter.add();
        }
        return Counter.count.get();
    }
}

class DesThread implements Callable<Integer> {
    @Override
    public Integer call() {
        for (int i = 0; i < 10000; i++) {
            Counter.dec();
        }
        return Counter.count.get();
    }
}