package com.fishs.chat16_design.creational.abstractFactory.pkg;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 13:39
 */
public interface HtmlDocument {
    String toHtml();
    void save(Path path) throws IOException;
}
