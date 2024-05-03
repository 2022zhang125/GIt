package com.hbsfdxwlxy.mybatis.configuration.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class ConfigurationTest {
    @Test
    public void testDataSource(){
        try {
            // sqlSessionFactory一个数据库只有一个，多创建没用
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 会话1
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("deleteStu",2);
            sqlSession.commit();
            // Returned connection 1799635803 to pool. 在关闭的时候，其实没有真正的关闭它， 而是让其返回到pool中，去等待下一次的调用
            sqlSession.close(); // 测试连接池所以要关闭，这里使用了pooled所以获取到的Connection对象一样。
            // 会话2
            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            sqlSession2.delete("deleteStu",3);
            sqlSession2.commit();
            sqlSession2.close(); // 测试连接池所以要关闭

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
