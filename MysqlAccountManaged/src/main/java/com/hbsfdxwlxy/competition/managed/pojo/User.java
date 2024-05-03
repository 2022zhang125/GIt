package com.hbsfdxwlxy.competition.managed.pojo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.util.Objects;

/**
 * 统计网站人数
 * 对User账户类进行封装，每次用户进行登录的时候都记录count到Session中，依次叠加。
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class User implements HttpSessionBindingListener {
    private String username;
    // 计数器，用于统计当前网站所在人数
    private String password;
    private static int count = 0;

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        User.count = count;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

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
    // 将我们的计数器与onlineUsers进行绑定操作
    private void UpdateOnlineServletContext(ServletContext servletContext){
        servletContext.setAttribute("onlineUsers",count);
    }

}
