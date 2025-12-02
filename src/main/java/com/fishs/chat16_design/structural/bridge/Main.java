package com.fishs.chat16_design.structural.bridge;

import com.fishs.chat16_design.structural.bridge.pkg.BossCar;
import com.fishs.chat16_design.structural.bridge.pkg.HybridEngine;
import com.fishs.chat16_design.structural.bridge.pkg.RefinedCar;

/**
 * @Description:将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * @Author: lf
 * @Date: 2025/12/2 15:45
 */
/*
简单说就是：产品（抽象维度的具体实现）和功能（实现维度的具体实现）是完全独立的两个体系，通过 “new 产品 (new 功能)” 这种 “组合注入” 的方式搭桥，让它们灵活搭配，不用提前写死各种组合。
 */
public class Main
{
    static void main() {
        BossCar refinedCar = new BossCar(new HybridEngine());
        refinedCar.drive();
    }
}
