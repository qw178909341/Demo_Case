package com.fishs.chat16_design.structural.adapter.pkg;

import java.util.concurrent.Callable;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 15:37
 */
public class RunnableAdapter implements Runnable {
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
