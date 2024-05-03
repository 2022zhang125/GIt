package com.hbsfdxwlxy.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * SqlSession工具类
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class SqlSessionUtil {
    private SqlSessionUtil(){}
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取会话对象
     * @return 会话对象
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
