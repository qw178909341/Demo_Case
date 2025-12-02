package com.fishs.chat16_design.creational.builder.pkg;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 14:51
 */
public class Computer {
    // 成员变量用 final 修饰，确保不可变，只能通过构造器赋值
    private final String cpu;       // 必须参数：CPU（如 Intel i9、AMD Ryzen 7）
    private final int ram;          // 必须参数：内存（单位：GB）
    private final int storage;      // 必须参数：硬盘（单位：GB）
    private final String graphicsCard; // 可选参数：显卡（无则为 "集成显卡"）
    private final String os;        // 可选参数：操作系统（无则为 "Windows 11"）
    private final boolean hasWifi;  // 可选参数：是否有无线网卡（默认 true）

    // 构造器：访问权限为 package-private（仅同包可见），只能由生成器调用
    Computer(String cpu, int ram, int storage, String graphicsCard, String os, boolean hasWifi) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        // 可选参数赋默认值（避免 null）
        this.graphicsCard = (graphicsCard != null) ? graphicsCard : "集成显卡";
        this.os = (os != null) ? os : "Windows 11";
        this.hasWifi = hasWifi;
    }

    // 只提供 getter 方法，无 setter 方法，保证对象不可变
    public String getCpu() { return cpu; }
    public int getRam() { return ram; }
    public int getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getOs() { return os; }
    public boolean isHasWifi() { return hasWifi; }

    // 重写 toString()，方便打印产品信息
    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ram + "GB" +
                ", storage=" + storage + "GB" +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", os='" + os + '\'' +
                ", hasWifi=" + hasWifi +
                '}';
    }
}