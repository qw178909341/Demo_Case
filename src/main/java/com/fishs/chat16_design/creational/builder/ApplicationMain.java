package com.fishs.chat16_design.creational.builder;

import com.fishs.chat16_design.creational.builder.pkg.Computer;
import com.fishs.chat16_design.creational.builder.pkg.ComputerBuilder;
import com.fishs.chat16_design.creational.builder.pkg.ConcreteComputerBuilder;

/**
 * @Description:将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * @Author: lf
 * @Date: 2025/12/2 14:45
 */
public class ApplicationMain {

    static void main() {
        ComputerBuilder builder = new ConcreteComputerBuilder();
        Computer computer = builder.setCpu("Intel i9")
                .setRam(16)
                .setStorage(512)
                .setGraphicsCard("NVIDIA RTX 3080")
                .setOs("Windows 11")
                .build();
        System.out.println(computer);
    }
}
