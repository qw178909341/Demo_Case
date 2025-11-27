package com.fishs.chat3.case1.examp3;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/18 10:07
 */
public class ApplicationMain {
    static void main() {
        People p = new People();
        p.say();
        p.run();
        p.show();
    }
}


class People implements PersonInterface{

    @Override
    public void say() {
        System.out.println("I am a person");
    }

    @Override
    public void run() {
        System.out.println("I am running");
    }
}