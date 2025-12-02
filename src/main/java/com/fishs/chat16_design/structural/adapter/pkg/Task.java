package com.fishs.chat16_design.structural.adapter.pkg;

import java.util.concurrent.Callable;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 15:35
 */
public class Task implements Callable<Long> {
    private long num;
    public Task(long num) {
        this.num = num;
    }
    @Override
    public Long call() throws Exception {
        long r = 0;
        for (long i = 1; i <= num; i++) {
            r += i;
        }
        System.out.println("Result :" + r);
        return r;
    }
}
