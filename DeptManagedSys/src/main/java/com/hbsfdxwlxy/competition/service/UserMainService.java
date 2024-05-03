package com.hbsfdxwlxy.competition.service;

import com.hbsfdxwlxy.competition.pojo.User;
import com.hbsfdxwlxy.competition.utils.SqlSessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * 用来处理User用户的所有业务逻辑操作
 *
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/user/main")
public class UserMainService extends ManagedService {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (SqlSession sqlSession = SqlSessionUtil.openSession()) {
            String path = (String) request.getAttribute("ServletPath");
            if ("/user/register".equals(path)) {
                doRegister(request, response, sqlSession);
            } else if ("/user/login".equals(path)) {
                doLogin(request, response, sqlSession);
            } else if ("/user/exit".equals(path)) {
                doExit(request, response, sqlSession);
            }
            sqlSession.commit();
            SqlSessionUtil.close(sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
            // 这里可以添加异常处理逻辑，比如返回错误信息给客户端
        }
    }

    private void doRegister(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userMapper.insertUser(new User(null, username, password));
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userMapper.selectUser(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/register.jsp");
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response, SqlSession sqlSession) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}

