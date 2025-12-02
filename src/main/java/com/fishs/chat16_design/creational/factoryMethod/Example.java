package com.fishs.chat16_design.creational.factoryMethod;

import com.fishs.chat16_design.creational.factoryMethod.demo.LocalDateFactory;
import com.fishs.chat16_design.creational.factoryMethod.demo.NumberFactory;
import org.junit.Test;

import java.security.MessageDigest;
import java.time.LocalDate;

/**
 * @Description:定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使一个类的实例化延迟到其子类。
 * @Author: lf
 * @Date: 2025/12/2 13:22
 */
public class Example {
    @Test
    public void Test(){
        LocalDate localDate = LocalDateFactory.fromInt(20251112);
        System.out.println(localDate);
    }
}

