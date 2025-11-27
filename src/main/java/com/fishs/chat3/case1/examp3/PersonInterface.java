package com.fishs.chat3.case1.examp3;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/18 10:07
 */
public interface PersonInterface extends BaseInterface {
    void say();
    default void show() {
        System.out.println("show");
    }
}
