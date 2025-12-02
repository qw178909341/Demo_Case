package com.fishs.chat16_design.creational.factoryMethod.demo;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 13:26
 */
public class NumberFactoryImpl implements NumberFactory{
    @Override
    public Number parse(String s) {
        return new BigDecimal( s);
    }
}
