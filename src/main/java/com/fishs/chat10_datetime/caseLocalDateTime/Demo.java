package com.fishs.chat10_datetime.caseLocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/28 10:51
 */
public class Demo {
    static void main() {
        //handlerCase1();
        //handlerCase2();
        //handlerCase3();
        handlerCase4();
    }

    static void handlerCase1() {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate ld = ldt.toLocalDate(); //LocalDate ld = LocalDate.now();
        LocalTime lt = ldt.toLocalTime(); //LocalTime lt = LocalTime.now();
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);
    }

    static void handlerCase2(){
        String date = "2025-11-28T10:11:11";  // 日期和时间必须带上标准分隔符T
        LocalDateTime ldt = LocalDateTime.parse(date);
        System.out.println(ldt);
    }

    static void handlerCase3(){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = dt.format(LocalDateTime.now());
        System.out.println( format);
        LocalDateTime parse = LocalDateTime.parse(format, dt);
        System.out.println(parse);
    }

    static void handlerCase4(){
        // 计算下个月的22号是周几
        LocalDateTime ldt = LocalDateTime.of(2025, 12, 22, 0, 0, 0);
        System.out.println(ldt.getDayOfWeek());
        // 计算二十天后是周几 是几号
        LocalDate plus = LocalDate.now().plus(20, ChronoUnit.DAYS);
        System.out.println(plus.getDayOfWeek() + " " + plus.getDayOfMonth());
    }


}
