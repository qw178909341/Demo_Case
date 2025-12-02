package com.fishs.chat16_design.structural.bridge.pkg;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 15:46
 */
public abstract class Car {
    protected Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }

    protected Car() {
    }

    public abstract void drive();
}
