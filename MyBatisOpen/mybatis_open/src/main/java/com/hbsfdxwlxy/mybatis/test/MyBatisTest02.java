package com.hbsfdxwlxy.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis完整的程序
 *
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class MyBatisTest02 {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 开启会话
            sqlSession = sqlSessionFactory.openSession();
            // 执行SQL语句
            int count = sqlSession.insert("insertStu");
            System.out.println(count);
            // 事务提交
            sqlSession.commit();
        } catch (Exception e) {
            // 回滚,sqlSession可能为null导致空指针引用
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            // 打印堆栈信息
            e.printStackTrace();
        } finally {
            // 关闭会话，释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
