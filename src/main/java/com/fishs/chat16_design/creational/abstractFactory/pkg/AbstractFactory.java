package com.fishs.chat16_design.creational.abstractFactory.pkg;

import com.fishs.chat16_design.creational.abstractFactory.pkg.FastImpl.FastFactory;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 13:38
 */
public interface AbstractFactory {
    HtmlDocument createHtmlDocument(String md);
    WordDocument createWordDocument(String md);

     static AbstractFactory createFactory(String type){
        if("fast".equals(type)){
            return new FastFactory();
        }
        return null;
    }
}
