package com.hbsfdxwlxy.mvc.utils;

import java.sql.*;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 *
 * JDBC连接的工具类
 */
public class DBUtils {
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources/info");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    // 注册驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static ThreadLocal<Connection> local = new ThreadLocal<>();
    /**
     *获取连接
     * @return 返回Connection对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = local.get();
        if (local.get() == null) {
            conn = DriverManager.getConnection(url,user,password);
            local.set(conn);
        }
        return conn;
    }

    /**
     * 释放内存
     * @param conn 连接对象
     * @param ps 数据库操作对象
     * @param rs 查询结果集
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
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
                local.remove();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private DBUtils() {

    }
}
