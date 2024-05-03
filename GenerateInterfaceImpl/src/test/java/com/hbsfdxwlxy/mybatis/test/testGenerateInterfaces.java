package com.hbsfdxwlxy.mybatis.test;

import com.hbsfdxwlxy.mybatis.dao.AccountDao;
import com.hbsfdxwlxy.mybatis.pojo.Account;
import com.hbsfdxwlxy.mybatis.utils.GenerateDaoImplement;
import com.hbsfdxwlxy.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

public class testGenerateInterfaces {
    @Test
    public void test(){
        AccountDao accountDao = (AccountDao) GenerateDaoImplement.GenerateDaoInterface(SqlSessionUtils.openSession(), AccountDao.class);

        // 使用生成的AccountDao接口实现调用方法
        Account account = accountDao.selectActByActno("someAccountId");  // 替换"someAccountId"为实际的账户ID
        System.out.println(account);

        int rowsUpdated = accountDao.updateActByActno(account);  // 使用上面查询到的账户对象
        System.out.println("Rows updated: " + rowsUpdated);
    }
}
