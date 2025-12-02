package com.fishs.chat9_io.caseFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 09:39
 */
public class Demo {
    static void main() throws IOException {
        File f = new File("src\\main\\java\\com\\fishs\\chat9_io\\caseFile");
        String absolutePath = f.getAbsolutePath();
        try (InputStream inputStream = new FileInputStream(absolutePath + "/test.txt")){
            byte[] bytes = new byte[1024];
            // 关键：记录每次实际读取的字节数，并使用这个数值来构造字符串
            int bytesRead;
            while ((bytesRead = inputStream.read(bytes, 0, bytes.length)) != -1) {
                System.out.println(new String(bytes, 0, bytesRead));
            }
        }

    }
}
