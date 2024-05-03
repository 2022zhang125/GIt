package com.hbsfdxwlxy.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisTest01 {
    public static void main(String[] args) throws Exception{
        // create SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // create SqlSessionFactory by sqlSessionFactoryBuilder's build method
        // at the same time We should give an InputStream from resources files
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // Other method to get the Stream
        /*InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");*/
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);

        // use the SqlSessionFactory to create SqlSession by openSession method
        SqlSession sqlSession = build.openSession();

        // implement SQL,Here we need to put the id of the StudentMapper.xml file
        // the count is deal tips
        int count = sqlSession.insert("insertStu");
        System.out.println("Already processed tips:" + count);

        // because of the framework already close auto of commit affairs,so we need commit by myself
        sqlSession.commit();
    }
}
