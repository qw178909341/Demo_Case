package com.fishs.chat16_design.structural.adapter;

import com.fishs.chat16_design.structural.adapter.pkg.RunnableAdapter;
import com.fishs.chat16_design.structural.adapter.pkg.Task;

import java.util.concurrent.Callable;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 15:29
 */
public class Main {
    static void main() {
        Callable<Long> callable = new Task(12345600L);
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}
