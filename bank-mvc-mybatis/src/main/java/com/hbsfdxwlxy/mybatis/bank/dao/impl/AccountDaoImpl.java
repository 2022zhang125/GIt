package com.hbsfdxwlxy.mybatis.bank.dao.impl;

import com.hbsfdxwlxy.mybatis.bank.dao.AccountDao;
import com.hbsfdxwlxy.mybatis.bank.pojo.Account;
import com.hbsfdxwlxy.mybatis.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 持久化层实现类，主要是对转账的数据进行操作，与业务无关，完全解耦合
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class AccountDaoImpl implements AccountDao {
    // 创建SqlSessionUtils对象
     public SqlSessionUtil sqlSessionUtils = new SqlSessionUtil();
     @Override
    public Account selectActByActno(String actno){
        SqlSession sqlSession = SqlSessionUtil.openSession();
         return (Account) sqlSession.selectOne("account.selectActByActno", actno);
    }
    @Override
    public int updateActByActno(Account act){
        SqlSession sqlSession = sqlSessionUtils.openSession();
        int count = sqlSession.update("account.updateActByActno", act);
        return count;
    }
}
