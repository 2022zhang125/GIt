package com.hbsfdxwlxy.competition.service;

import com.hbsfdxwlxy.competition.mapper.DeptMapper;
import com.hbsfdxwlxy.competition.mapper.UserMapper;
import com.hbsfdxwlxy.competition.utils.SqlSessionUtil;
import jakarta.servlet.http.HttpServlet;

public class ManagedService extends HttpServlet{
    public static String password;
    public static String username;
    public static String deptno;
    public static Long id;
    public static String dname;
    public static String loc;
    public DeptMapper deptMapper = SqlSessionUtil.openSession().getMapper(DeptMapper.class);
    public UserMapper userMapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
}
