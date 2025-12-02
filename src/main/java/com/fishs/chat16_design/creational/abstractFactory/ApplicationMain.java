package com.fishs.chat16_design.creational.abstractFactory;

import com.fishs.chat16_design.creational.abstractFactory.pkg.AbstractFactory;
import com.fishs.chat16_design.creational.abstractFactory.pkg.FastImpl.FastFactory;
import com.fishs.chat16_design.creational.abstractFactory.pkg.HtmlDocument;
import com.fishs.chat16_design.creational.abstractFactory.pkg.WordDocument;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Description:提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * @Author: lf
 * @Date: 2025/12/2 13:36
 */
public class ApplicationMain {
    static void main() throws IOException {
        AbstractFactory fast = AbstractFactory.createFactory("fast");
        // 生成Html文档:
        HtmlDocument html = fast.createHtmlDocument("#Hello\nHello, world!");
        html.save(Paths.get(".", "fast.html"));
        // 生成Word文档:
        WordDocument word = fast.createWordDocument("#Hello\nHello, world!");
        word.save(Paths.get(".", "fast.doc"));
    }
}
