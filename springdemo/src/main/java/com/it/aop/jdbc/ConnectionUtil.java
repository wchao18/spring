package com.it.aop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://192.168.13.170:3306/aop_test?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
    public final static String DB_USERNAME = "root";
    public final static String DB_PASSWORD = "Root!@#";

    public static Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Connection con = null;
        Class.forName(DB_DRIVER_CLASS);
        con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        System.out.println("DB Connection created successfully");
        return con;
    }
}
