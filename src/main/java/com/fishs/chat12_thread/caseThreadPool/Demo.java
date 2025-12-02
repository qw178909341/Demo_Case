package com.fishs.chat12_thread.caseThreadPool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 16:55
 */
public class Demo {
   static ScheduledExecutorService sec = Executors.newScheduledThreadPool(4);

    public static void main(String[] args) {
        sec.scheduleAtFixedRate(new Task(), 5, 3, java.util.concurrent.TimeUnit.SECONDS);
    }
}
class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("线程开始！" + LocalDateTime.now());
    }
}
