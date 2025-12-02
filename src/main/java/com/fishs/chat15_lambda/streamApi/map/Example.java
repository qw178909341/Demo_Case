package com.fishs.chat15_lambda.streamApi.map;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 10:23
 */
public class Example {
    @Test
    public void Test(){
        List<String> strings = List.of("2025-11-12", "2025-11-13", "2025-11-14");
        List<LocalDate> list = strings.stream().map((s) -> LocalDate.parse(s).plus(20, ChronoUnit.DAYS)).toList();
        System.out.println( list);
    }
}
