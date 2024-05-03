package com.hbsfdxwlxy.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis工具类
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    // 静态代码块在类加载的时候去解析mybatis-config.xml文件，创建一个SqlSessionFactory对象
    static{
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private SqlSessionUtil() {}

    /**
     * 获取会话对象
     * @return 会话对象
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
