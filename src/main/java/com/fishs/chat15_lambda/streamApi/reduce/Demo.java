package com.fishs.chat15_lambda.streamApi.reduce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 10:35
 */
public class Demo {
    static void main() {
        //List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //System.out.println(integers.stream().reduce((a, b) -> a + b));

        List<String> props = List.of("profile=native","debug=true","logging=warn","interval=500");
        Map<String, String> reduce = props.stream().map(kv -> {
            String[] kvArr = kv.split("=");
            return Map.of(kvArr[0], kvArr[1]);
        }).reduce(new HashMap<String, String>(), (m, kv) -> {
            m.putAll(kv);
            return m;
        });
        System.out.println(reduce);
    }
}
