package com.fishs.chat12_thread.caseInterrupted;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 14:03
 */
public class Demo {
    // 用于存储所有创建的线程，方便主线程统一管理
    private static List<MyThread> threadList = new ArrayList<>();

    @Test
    public void Test() throws InterruptedException {
        // 创建并启动10个线程，同时保存到列表中
        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread(i);
            threadList.add(thread);
            thread.start();
        }

        // 主线程等待500毫秒
        Thread.sleep(500);
        System.out.println("=== 500ms已过，开始中断长时间运行的线程 ===");

        // 遍历所有线程，中断那些预计执行时间超过500ms的线程
        for (MyThread thread : threadList) {
            if (thread.getTimeout() > 500) {
                thread.interrupt(); // 主动中断线程
            }
        }

        // 等待所有线程结束（可选，用于JUnit测试中防止主线程提前退出）
        for (MyThread thread : threadList) {
            thread.join();
        }
    }

    static class MyThread extends Thread {
        private int index;
        private int timeout; // 保存预计休眠时间，供主线程判断

        public MyThread(int index) {
            this.index = index;
        }

        public int getTimeout() {
            return timeout;
        }

        @Override
        public void run() {
            // 随机生成0-1000毫秒的执行时间
            timeout = (int) (Math.random() * 1000);
            System.out.println("线程 " + index + " 预计执行时间 " + timeout + " ms");

            try {
                // 模拟任务执行（sleep）
                Thread.sleep(timeout);
                // 如果未被中断，打印完成信息
                System.out.println("线程 " + index + " 正常执行完毕！");
            } catch (InterruptedException e) {
                // 捕获中断异常，打印被中断信息
                System.out.println("线程 " + index + " 执行时间超过500ms，被中断！");
            }
        }
    }
}
