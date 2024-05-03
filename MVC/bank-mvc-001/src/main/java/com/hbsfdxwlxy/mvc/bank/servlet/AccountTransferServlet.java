package com.hbsfdxwlxy.mvc.bank.servlet;

import com.hbsfdxwlxy.mvc.bank.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/transfer")
public class AccountTransferServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String fromActno = request.getParameter("fromActno"); // 转出账户
        String toActno = request.getParameter("toActno");// 转入账户
        double money = Double.parseDouble(request.getParameter("money"));
//        System.out.println(fromActno + toActno + money);
        /*
        * 转出者的钱：formActno.money - money
        * 转入者的钱：toActno.money + money
        * */
        // 转出前要查是否有充足的钱去转账
        // 连接JDBC
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select balance from t_act where actno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, fromActno);
            rs = ps.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                // 判断余额是否足够进行转账
                if (balance >= money) {
                    // 执行转账操作
                    // 注意：在这里编写转账的逻辑
                    // 更新转出账户和转入账户的余额
                } else {
                    // 余额不足，输出提示信息或者抛出异常
                    // 注意：根据实际需求进行处理
                }
            } else {
                // 没有找到对应账户，输出提示信息或者抛出异常
                // 注意：根据实际需求进行处理
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }

    }
}
