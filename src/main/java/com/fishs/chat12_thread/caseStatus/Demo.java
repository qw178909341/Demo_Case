package com.fishs.chat12_thread.caseStatus;

import org.junit.Test;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 13:51
 */
public class Demo {
    // 线程状态 分为 New 新建，Runnable 运行，Blocked 阻塞，Waiting 等待中，Timed Waiting 超时等待，Terminated 运行结束
    @Test
    public void test() throws Exception{
        for (int i = 0; i < 10; i++) {
             new Thread(new MyThread(i)).start();
        }
        Thread.sleep(1000);
    }

}

class MyThread implements Runnable {
    private Integer i;

    public MyThread(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("线程 " + i + "正在执行！");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程 " + i + "执行结束！");
    }
}