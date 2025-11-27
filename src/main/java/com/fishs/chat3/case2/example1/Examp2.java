package com.fishs.chat3.case2.example1;

import java.util.StringJoiner;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/21 10:57
 */
public class Examp2 {
    public static void main(String[] args) {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    static String buildSelectSql(String table, String[] fields) {
        StringJoiner sj = new StringJoiner( ", ","SELECT ", " FROM " + table);
        for (String field : fields) {
            sj.add(field);
        }
        System.out.println(sj);
        return sj.toString();
    }
}
