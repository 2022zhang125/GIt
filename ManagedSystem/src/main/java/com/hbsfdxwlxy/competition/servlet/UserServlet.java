package com.hbsfdxwlxy.competition.servlet;

import com.hbsfdxwlxy.competition.bean.User;
import com.hbsfdxwlxy.competition.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet({"/user/login","/user/exit","/user/register"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        System.out.println("Executing doRegister");
        if ("/user/login".equals(servletPath)) {
            doLogin(request, response);
        } else if ("/user/exit".equals(servletPath)) {
            doExit(request, response);
        } else if ("/user/register".equals(servletPath)) {
            doRegister(request, response);
        }
    }

    /**
     * 注册功能，将用户的注册信息存入t_user表中
     *
     * @param request
     * @param response
     */
    private void doRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        String sql = "insert into t_user(username,password) values(?,?)";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            String username = request.getParameter("username");
            String userpwd = request.getParameter("userpwd");
            System.out.println("Registering user: " + username);  // 调试输出
            ps.setString(1, username);
            ps.setString(2, userpwd);

            int i = ps.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            // 打印或记录错误信息
            e.printStackTrace();
            throw new RuntimeException("注册失败: " + e.getMessage(), e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        if (flag) {
            System.out.println("Registration successful");  // 调试输出
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } else {
            System.out.println("Registration failed");  // 调试输出
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }



    /**
     * 用户安全退出
     *
     * @param request
     * @param response
     */
    private void doExit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            session.removeAttribute("user");
            session.invalidate();
            response.getWriter().print("<h1>退出成功</h1>");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     */
    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean f = false;
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select username,password from t_user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, userpwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                f = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        if (f) {
            System.out.println("登录成功");
            HttpSession session = request.getSession();
            User user = new User(username);
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
