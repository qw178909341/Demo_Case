package com.fishs.chat14_jdbc.select;

import java.sql.*;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/1 16:37
 */
public class Demo
{
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://192.168.188.128:3306/study_test?useSSL=false";
        String user = "root";
        String password = "123456";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT id, username, email, password FROM user WHERE id = ?")) {
                stmt.setObject(1, 1);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        String username = rs.getString(2);
                        String email = rs.getString(3);
                        String pwd = rs.getString(4);
                        System.out.printf("id: %d, username: %s, email: %s, password: %s%n", id, username, email, pwd);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
