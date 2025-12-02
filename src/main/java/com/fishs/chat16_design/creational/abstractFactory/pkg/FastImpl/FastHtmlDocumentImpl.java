package com.fishs.chat16_design.creational.abstractFactory.pkg.FastImpl;

import com.fishs.chat16_design.creational.abstractFactory.pkg.HtmlDocument;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 13:41
 */
public class FastHtmlDocumentImpl implements HtmlDocument {
    @Override
    public String toHtml() {
        return "";
    }

    @Override
    public void save(Path path) throws IOException {

    }
}
