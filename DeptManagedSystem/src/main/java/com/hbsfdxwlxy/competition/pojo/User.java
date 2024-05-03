package com.hbsfdxwlxy.competition.pojo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.util.Objects;

/**
 * 该类不仅是一个普通的Java用户类，不仅封装了对象，而且实现了HttpSessionBindingListener接口，用于监听Session域中存放事件，实时显示网站在线人数。
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class User implements HttpSessionBindingListener {
    private String username;
    private String password;
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
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
