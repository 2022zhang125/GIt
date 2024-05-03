package com.hbsfdxwlxy.mybatis.bank.service.impl;

import com.hbsfdxwlxy.mybatis.bank.dao.AccountDao;
import com.hbsfdxwlxy.mybatis.bank.dao.impl.AccountDaoImpl;
import com.hbsfdxwlxy.mybatis.bank.exceptions.MoneyNotEnoughException;
import com.hbsfdxwlxy.mybatis.bank.exceptions.TransferErrorException;
import com.hbsfdxwlxy.mybatis.bank.pojo.Account;
import com.hbsfdxwlxy.mybatis.bank.service.AccountService;
import com.hbsfdxwlxy.mybatis.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 业务逻辑层的实际实现类
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class AccountServiceImpl implements AccountService {
    public void transfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TransferErrorException {

        // 事务管理
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 判断转出账余额是否充足（select）
        AccountDao dao = new AccountDaoImpl();
        Account fromAct = dao.selectActByActno(fromActno);
        if (fromAct.getMoney() < money) {
            // 如果不充足的话，抛异常
            throw new MoneyNotEnoughException("余额不足");
        }
        // 如果充足，进行转账操作（update）
        Account toAct = dao.selectActByActno(toActno);
        // 先改变内存中的值，再去改变数据库中的值（update）

        // 改变转出账户余额
        fromAct.setMoney(fromAct.getMoney() - money);
        // 改变转入账户余额
        toAct.setMoney(toAct.getMoney() + money);

        // 更新数据
        int count = dao.updateActByActno(fromAct);
/*        // 模拟异常
        String s = null;
        s.toString();*/
        count += dao.updateActByActno(toAct);
        if (count!=2) {
            // 转账失误，抛异常
            throw new TransferErrorException("转账失败，请联系管理员");
        }
        // 事务的提交
        sqlSession.commit();

        // 事务的关闭
        SqlSessionUtil.close(sqlSession);
    }
}
