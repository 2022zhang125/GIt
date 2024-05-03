package com.hbsfdxwlxy.mybatis.bank.service;

import com.hbsfdxwlxy.mybatis.bank.exceptions.MoneyNotEnoughException;
import com.hbsfdxwlxy.mybatis.bank.exceptions.TransferErrorException;

/**
 * 业务逻辑接口，主要去解除层与层之间的耦合。
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public interface AccountService {

    /**
     * 转账业务逻辑代码
     * @param fromActno 转出账户
     * @param toActno 转入账户
     * @param money 转出金额
     */
    void transfer(String fromActno,String toActno,Double money) throws MoneyNotEnoughException, TransferErrorException;
}
