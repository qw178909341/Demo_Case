package com.fishs.chat16_design.creational.singleton;

import com.fishs.chat16_design.creational.singleton.pkg.Student;

/**
 * @Description:保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * @Author: lf
 * @Date: 2025/12/2 15:21
 */
public class Main
{
    static void main() {
        Student instance = Student.getInstance();
        instance.setName("张三");
        System.out.println(instance);
        Student instance1 = Student.getInstance();
        System.out.println(instance1);
        System.out.println(instance == instance1);
    }
}
