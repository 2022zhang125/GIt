package com.hbsfdxwlxy.mvc.bank.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private static final String driver = bundle.getString("driver");
    private static final String url = "jdbc:mysql://localhost:3306/mvc";
    private static final String user = "root";
    private static final String password = "123456";

/*    private static final String url = bundle.getString("url");
    private static final String user = bundle.getString("user");
    private static final String password = bundle.getString("password");*/

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load JDBC driver", e);
        }
    }

    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish database connection", e);
        }
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("Failed to close ResultSet: " + e.getMessage());
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.err.println("Failed to close Statement: " + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Failed to close Connection: " + e.getMessage());
            }
        }
    }
}

