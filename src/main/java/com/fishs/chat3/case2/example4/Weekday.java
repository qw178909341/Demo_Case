package com.fishs.chat3.case2.example4;

import java.awt.*;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/24 13:34
 */
public enum Weekday {
    MON(1,"星期一"),
    TUE(2,"星期二"),
    WED(3,"星期三"),
    THU(4,"星期四"),
    FRI(5,"星期五"),
    SAT(6,"星期六"),
    SUN(7,"星期日");

    private final int value;
    private final String name;

    private Weekday(int value, String name) {
        this.value = value;
        this.name = name;

    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public boolean equals( Weekday other) {
        return this.getValue()  == other.getValue();
    }

    public String toString() {
        return String.format("今天是%s", this.getName());
    }
}
