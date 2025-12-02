package com.fishs.chat12_thread.caseSync;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 15:25
 */
public class Demo {
    @Test
    public void Test() throws  Exception{
        AddThread addThread = new AddThread();
        DecThread decThread = new DecThread();
        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();
        System.out.println(Counter.count);
    }
}
class Counter{
    public static AtomicInteger  count = new AtomicInteger(0);
}

class AddThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100001; i++) Counter.count.incrementAndGet();
    }
}
class DecThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) Counter.count.decrementAndGet();
    }
}
