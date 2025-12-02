package com.fishs.chat16_design.structural.bridge.pkg;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 15:54
 */
public class BossCar extends RefinedCar
{
    public BossCar(Engine engine) {
        super(engine);
    }
    @Override
    public String getBrand() {
        return "Boss";
    }
}
