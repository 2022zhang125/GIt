package com.hbsfdxwlxy.competition.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 */
public class DBUtil {
    // 静态变量
    private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    static {
        // 注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接对象
     *
     * @return conn 连接对象
     */
    public static Connection getConnection() {
        // 获取连接
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放资源
     *
     * @param conn 连接对象
     * @param ps   数据库操作对象
     * @param rs   结果集对象
     */
    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
