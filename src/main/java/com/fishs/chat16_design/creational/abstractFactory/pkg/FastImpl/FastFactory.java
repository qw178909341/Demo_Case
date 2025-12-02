package com.fishs.chat16_design.creational.abstractFactory.pkg.FastImpl;

import com.fishs.chat16_design.creational.abstractFactory.pkg.AbstractFactory;
import com.fishs.chat16_design.creational.abstractFactory.pkg.HtmlDocument;
import com.fishs.chat16_design.creational.abstractFactory.pkg.WordDocument;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 13:42
 */
public class FastFactory implements AbstractFactory {


    @Override
    public HtmlDocument createHtmlDocument(String md) {
        return new FastHtmlDocumentImpl();
    }

    @Override
    public WordDocument createWordDocument(String md) {
        return new FastWordDocumentImpl();
    }
}
