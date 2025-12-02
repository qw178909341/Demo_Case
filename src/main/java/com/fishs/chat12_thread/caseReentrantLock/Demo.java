package com.fishs.chat12_thread.caseReentrantLock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 16:19
 */
public class Demo {
    private final Lock lock = new ReentrantLock();
    @Test
    public void Test(){
        AddThread addThread = new AddThread();
        DesThread decThread = new DesThread();
        addThread.start();
        decThread.start();
        try {
            addThread.join();
            decThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Counter.count);
    }
}
class Counter {
    private static final Lock lock = new ReentrantLock();

    public static int count = 0;
    public static void add() {
        lock.lock();
        count++;
        lock.unlock();
    }
    public static void dec() {
        lock.lock();
        count--;
        lock.unlock();

    }
}
class AddThread extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 100001; i++) Counter.add();
    }
}

class DesThread extends Thread{
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) Counter.dec();

    }
}