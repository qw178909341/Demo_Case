package com.fishs.chat3.case2.example1;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/21 10:24
 */
public class Examp1 {
    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String insert = buildInsertSql2(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(table).append(" (");

        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if (i != fields.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(") VALUES (");
        for (int i = 0; i < fields.length; i++) {
            sb.append("?");
            if (i != fields.length - 1) {
                sb.append(", ");
            } else {
                sb.append(")");
            }
        }
        return sb.toString();
    }

    static String buildInsertSql2(String table, String[] fields) {
        String filedStr = String.join(", ", fields);
        String[] arrays = new String[fields.length];

        Arrays.fill(arrays, "?");
        String valueStr = String.join(", ",arrays );
        return "INSERT INTO " + table + " (" + filedStr + ") VALUES (" + valueStr + ")";
    }
}
