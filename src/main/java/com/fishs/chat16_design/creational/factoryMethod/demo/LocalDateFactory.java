package com.fishs.chat16_design.creational.factoryMethod.demo;

import java.time.LocalDate;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 13:34
 */
public class LocalDateFactory
{
    public static LocalDate fromInt(int yyyyMMdd){
        return LocalDate.of(yyyyMMdd/10000, (yyyyMMdd%10000)/100, yyyyMMdd%100);
    }
}
