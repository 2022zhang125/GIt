package com.hbsfdxwlxy.competition.web;

import com.hbsfdxwlxy.competition.utils.SqlSessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * 业务控制类，主要将所有请求第一遍都走这里，进行分类处理
 * 统一进行事务处理
 * @author BelieveSun
 * @since 1.0
 * @version 1.0
 */
@WebServlet({"/user/register","/user/exit","/user/login","/dept/list","/dept/add","/dept/delete"})
public class ManagedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String path = servletPath.split("/")[1];
        // 获取前端数据
        if ("user".equals(path)) {
            request.setAttribute("ServletPath",servletPath);
            request.getRequestDispatcher("/user/main").forward(request, response);
        }else if("dept".equals(path)){
            request.setAttribute("ServletPath",servletPath);
            request.getRequestDispatcher("/dept/main").forward(request,response);
        }
    }
}
