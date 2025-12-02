package com.fishs.chat16_design.creational.builder.pkg;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 14:52
 */
public class ConcreteComputerBuilder implements ComputerBuilder{
    // 存储产品的临时属性（对应 Computer 的成员变量）
    private String cpu;
    private int ram;
    private int storage;
    private String graphicsCard;
    private String os;
    private boolean hasWifi = true; // 可选参数默认值

    // 实现接口方法：返回 this，支持链式调用（如 builder.setCpu().setRam()）
    @Override
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    @Override
    public ComputerBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    @Override
    public ComputerBuilder setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
        return this;
    }

    // 构建产品：校验必须参数，创建 Computer 实例（调用其构造器）
    @Override
    public Computer build() {
        // 校验必须参数（避免创建不完整的对象）
        if (cpu == null || ram <= 0 || storage <= 0) {
            throw new IllegalArgumentException("CPU、内存、硬盘为必须参数，且不能为无效值");
        }
        // 调用 Computer 的构造器创建不可变对象
        return new Computer(cpu, ram, storage, graphicsCard, os, hasWifi);
    }
}