package com.hbsfdxwlxy.competition.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Filter过滤系统
 * @author BelieveSun
 * @since 1.0
 * @version 1.0
 */
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 获取请求路径
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession(false);
        if("/user/login".equals(servletPath) ||
                "/index.jsp".equals(servletPath) ||
                "/user/exit".equals(servletPath) ||
                "/user/register".equals(servletPath) ||
                "/success.jsp".equals(servletPath) ||
                "/error.jsp".equals(servletPath) ||
                "/register.jsp".equals(servletPath) ||
                "/login.jsp".equals(servletPath) || session != null && session.getAttribute("user") != null){
            chain.doFilter(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }
}
