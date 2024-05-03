package com.hbsfdxwlxy.competition.managed.service;

import com.hbsfdxwlxy.competition.managed.exceptions.LoginErrorException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface UserService extends ManagedService {
    // 对于User类的处理
    // 登录
    void doLogin(HttpServletRequest request, HttpServletResponse response) throws LoginErrorException, IOException;

    // 注册
    void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException;

    // 退出
    void doExit(HttpServletRequest request, HttpServletResponse response);

}
