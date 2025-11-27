package com.fishs.chat8_collection.caseProperties;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/27 15:51
 */
public class Demo {

    static void main(String[] args)  throws  Exception{
        String f = "E:\\Work Code\\Demo_Case\\src\\main\\java\\com\\fishs\\chat8_collection\\caseProperties\\demo.properties";
        Properties props = new Properties();
        props.load(new FileInputStream(f));
        System.out.println(props.getProperty("name"));
    }
}
