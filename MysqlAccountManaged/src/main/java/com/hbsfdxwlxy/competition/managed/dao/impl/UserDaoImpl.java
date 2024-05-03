package com.hbsfdxwlxy.competition.managed.dao.impl;

import com.hbsfdxwlxy.competition.managed.dao.UserDao;
import com.hbsfdxwlxy.competition.managed.pojo.User;
import com.hbsfdxwlxy.competition.managed.utils.SqlSessionUtils;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectUser(User user) {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        Map<String,String> map = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        User users = sqlSession.selectOne("selectUser", map);
        return users;
    }

    @Override
    public int insertUser(User user) {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        Map<String,String> map = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        return sqlSession.insert("insertUser",user);
    }
}
