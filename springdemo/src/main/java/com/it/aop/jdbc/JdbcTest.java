package com.it.aop.jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://192.168.13.170:3306/aop_test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
        String USER = "root";
        String PASSWORD = "Root!@#";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("select * from test");
        while (rs.next()) {
            System.out.println(rs.getString("num"));
        }
        rs.close();
        st.close();
        conn.close();
    }
}
