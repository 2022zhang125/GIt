package com.hbsfdxwlxy.competition.managed.service.impl;

import com.hbsfdxwlxy.competition.managed.dao.UserDao;
import com.hbsfdxwlxy.competition.managed.dao.impl.UserDaoImpl;
import com.hbsfdxwlxy.competition.managed.exceptions.LoginErrorException;
import com.hbsfdxwlxy.competition.managed.pojo.User;
import com.hbsfdxwlxy.competition.managed.service.UserService;
import com.hbsfdxwlxy.competition.managed.utils.SqlSessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/user/login","/user/exit","/user/register"})
public class UserServiceImpl extends HttpServlet implements UserService {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取路径
        String servletPath = request.getServletPath();
        if ("/user/login".equals(servletPath)) {
            doLogin(request, response);
        } else if ("/user/exit".equals(servletPath)) {
            doExit(request, response);
        } else if ("/user/register".equals(servletPath)) {
            doRegister(request, response);
        }
    }

    @Override
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // boolean flag
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao dao = new UserDaoImpl();
        User loginUser = dao.selectUser(user);
        // if return null then throw Exception
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
        // 登录成功，执行depr/listServlet进行list页面的查询
        System.out.println("登录成功");
        // 创建session信息
        HttpSession session = request.getSession(); // 如果有就不创建，如果没有就创建
        //session.setAttribute("username",username); // 将用户名存入session中
        // 将登录成功的对象放入session域中
        session.setAttribute("user",user); // 此时会启动User的HttpSessionBindingListener中的ValueBound方法让count++
        response.sendRedirect(request.getContextPath()+"/dept/list");
    }

    @Override
    public void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        SqlSession sqlSession = SqlSessionUtils.openSession();
        UserDao dao = new UserDaoImpl();
        User loginUser = dao.selectUser(user);
        if (loginUser == null) {
            // 执行注册操作
            int count = dao.insertUser(user);
            if (count == 1) {
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        }
        // 跳转到登录界面，并显示账号已存在
    }

    @Override
    public void doExit(HttpServletRequest request, HttpServletResponse response) {

    }
}
