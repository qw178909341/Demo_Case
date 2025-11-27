package com.fishs.chat3.case2.example4;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/24 13:33
 */
public class ApplicationMain {
    static void main() {
        Weekday weekday = Weekday.MON;
        System.out.println(weekday.getName());
        System.out.println(weekday.getValue());
        System.out.println(weekday.equals(Weekday.THU));
        System.out.println(weekday);
    }
}
