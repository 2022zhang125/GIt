package com.hbsfdxwlxy.competition.bean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private String username;
    private static int count = 0;
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 当我们的User对象被存储到session域时，我们进行计数操作
        count ++;
        // 将count存储到ServletContext中
        UpdateOnlineServletContext(event.getSession().getServletContext());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 当我们的用户从session域中移除的时候，就代表着用户退出系统时，让count--
        count--;
        UpdateOnlineServletContext(event.getSession().getServletContext());
    }
    private void UpdateOnlineServletContext(ServletContext servletContext){
        servletContext.setAttribute("onlineUsers",count);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
