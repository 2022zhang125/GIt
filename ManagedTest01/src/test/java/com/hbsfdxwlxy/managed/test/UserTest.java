package com.hbsfdxwlxy.managed.test;

import com.hbsfdxwlxy.managed.mapper.UserMapper;
import com.hbsfdxwlxy.managed.pojo.User;
import com.hbsfdxwlxy.managed.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    @Test
    public void testInsert(){
        // 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 通过代理机制去直接获取到我们的接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 通过代理对象调用对应的方法
        // 封装User对象
        User user = new User(null,"ZhangSan","12112121");
        int count = mapper.insert(user);
        System.out.println(count);
        // 提交事件
        sqlSession.commit();
    }
}
