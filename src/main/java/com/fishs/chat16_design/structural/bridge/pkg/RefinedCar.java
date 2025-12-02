package com.fishs.chat16_design.structural.bridge.pkg;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 15:48
 */
public abstract class RefinedCar extends Car {
    public RefinedCar(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        this.engine.start();
        System.out.println("Drive " + getBrand() + " car...");
    }

    public abstract String getBrand();
}
