package com.fishs.chat12_thread.caseSync;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 16:05
 */
public class WaitAndNotify {
    @Test
    public void Test() throws Exception{
        TaskQueue taskQueue = new TaskQueue();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    taskQueue.addTask("1");
                }
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        taskQueue.removeTask();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();
        thread.join();
        thread1.join();
    }
}



class TaskQueue{
    Queue<String> queue = new LinkedList<>();
    public synchronized  void addTask(String s){
        queue.add(s);
        this.notifyAll();
    }
    public synchronized void removeTask() throws InterruptedException {
        while (queue.isEmpty()){
            this.wait();
        }
        queue.remove();
    }
}