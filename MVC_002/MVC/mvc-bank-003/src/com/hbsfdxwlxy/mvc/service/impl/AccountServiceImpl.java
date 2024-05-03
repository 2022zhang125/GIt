package com.hbsfdxwlxy.mvc.service.impl;

import com.hbsfdxwlxy.mvc.dao.impl.AccountDaoImpl;
import com.hbsfdxwlxy.mvc.pojo.Account;
import com.hbsfdxwlxy.mvc.dao.AccountDao;
import com.hbsfdxwlxy.mvc.exceptions.AppErrorException;
import com.hbsfdxwlxy.mvc.exceptions.MoneyNotEnoughException;
import com.hbsfdxwlxy.mvc.exceptions.NullAccountException;
import com.hbsfdxwlxy.mvc.service.AccountService;
import com.hbsfdxwlxy.mvc.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author BelieveSun
 * @since 1.0
 * @version 1.0
 *
 * 该类用于处理业务逻辑，也就是Model
 */
public class AccountServiceImpl implements AccountService {
    public void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, AppErrorException, NullAccountException {
        AccountDao dao = new AccountDaoImpl();
        Connection conn = null;
        int count = 0;
        try {
            conn = DBUtils.getConnection();

            // 开启事务
            conn.setAutoCommit(false);
            // 连接数据库查询是否满足金额
            Account fromAccount = dao.selectFromActno(fromActno);
            Account toAccount = dao.selectFromActno(toActno);
            if (fromAccount == null || toAccount == null) {
                throw new NullAccountException("数据库中没有此对象");
            }
            if (fromAccount.getBalance() < money) {
                // 金额不足
                throw new MoneyNotEnoughException("余额不足");
            }
            // 金额充足，进行转账操作
            fromAccount.setBalance(fromAccount.getBalance() - money);
            toAccount.setBalance(toAccount.getBalance() + money);
            // 更新数据库内数据
            count+=dao.update(fromAccount);
            count+=dao.update(toAccount);
            if (count != 2) {
                throw new AppErrorException("服务器异常，请联系管理员");
            }
            // 提交事务
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(conn,null,null);
        }
    }
}
