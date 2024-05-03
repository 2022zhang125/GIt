package com.hbsfdxwlxy.competition.service;

import com.hbsfdxwlxy.competition.pojo.Dept;
import com.hbsfdxwlxy.competition.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * 业务逻辑层接口
 * 用于对外提供所有需要用到的业务
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public interface DMSService {
    // 用户层面的操作
    Boolean login(String username);
    Boolean register(User user);
    void exit(HttpServletRequest request, HttpServletResponse response) throws IOException;

    // 部门层面操作
    List<Dept> doList();
    Boolean doAdd(Dept dept);
    Boolean doDel(String deptno);
    Boolean doEdit(Dept dept);
    Dept doDetail(String deptno);
}
