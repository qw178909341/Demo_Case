package com.fishs.chat16_design.creational.factoryMethod.demo;

import java.math.BigDecimal;

public interface NumberFactory{
    Number parse(String s);

    static Number getFactory(String s){
        return new BigDecimal(s);
    }
}
