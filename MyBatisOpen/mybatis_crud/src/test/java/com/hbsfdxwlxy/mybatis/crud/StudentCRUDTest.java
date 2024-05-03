package com.hbsfdxwlxy.mybatis.crud;

import com.hbsfdxwlxy.mybatis.pojo.Student;
import com.hbsfdxwlxy.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentCRUDTest {
    /**
     * 测试MyBatis的插入功能
     */
    @Test
    public void testInsertStu(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String, Student> StudentMap = new HashMap<>();
        // 执行SQL
        // int count = sqlSession.insert("insertStu",对象);
        // 对Student类进行封装
        Student stu = new Student("啊哈","4000",'F');
        // 将Student对象添加到Map集合中
        StudentMap.put("stu",stu);
        int count = sqlSession.insert("insertStu",StudentMap);

        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
