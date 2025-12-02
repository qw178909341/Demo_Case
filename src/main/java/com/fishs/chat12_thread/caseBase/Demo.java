package com.fishs.chat12_thread.caseBase;

import org.junit.Test;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 13:40
 */
public class Demo {
    @Test
    public void test() throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("二号线程：线程开始！");
                System.out.println("二号线程：线程结束！");
            }
        });
        t.start();
        Thread.sleep(1000);
        System.out.println("main主线程执行！");
    }

}
class MyThread extends Thread {
    @Override

    public void run() {
        System.out.println("线程开始！");
        System.out.println("线程结束！");
    }
}
