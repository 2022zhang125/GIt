package com.hbsfdxwlxy.competition.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 获取请求路径
        String servletPath = request.getServletPath();

        // 检查请求是否允许通过过滤器
        if (isAllowedPath(servletPath, request.getSession(false))) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    /**
     * 检查请求路径是否允许通过过滤器
     *
     * @param servletPath 请求路径
     * @param session     HttpSession对象
     * @return boolean    请求是否允许通过过滤器
     */
    private boolean isAllowedPath(String servletPath, HttpSession session) {
        return "/user/login".equals(servletPath) ||
                "/user/exit".equals(servletPath) ||
                "/register.jsp".equals(servletPath) ||
                "/login.jsp".equals(servletPath) ||
                "/index.jsp".equals(servletPath) ||
                "/user/register".equals(servletPath)||
                "/user/success".equals(servletPath)||
                "/user/error".equals(servletPath)||
                (session != null && session.getAttribute("user") != null);
    }
}
