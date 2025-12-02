package com.fishs.chat16_design.creational.builder.pkg;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 14:52
 */
public interface ComputerBuilder {
    // 必须参数：设置 CPU
    ComputerBuilder setCpu(String cpu);
    // 必须参数：设置内存
    ComputerBuilder setRam(int ram);
    // 必须参数：设置硬盘
    ComputerBuilder setStorage(int storage);
    // 可选参数：设置显卡（默认集成显卡）
    ComputerBuilder setGraphicsCard(String graphicsCard);
    // 可选参数：设置操作系统（默认 Windows 11）
    ComputerBuilder setOs(String os);
    // 可选参数：设置是否有无线网卡（默认 true）
    ComputerBuilder setHasWifi(boolean hasWifi);
    // 核心方法：构建并返回最终电脑对象
    Computer build();
}
