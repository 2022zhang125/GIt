package com.hbsfdxwlxy.mybatis.bank.dao;

import com.hbsfdxwlxy.mybatis.bank.pojo.Account;

public interface AccountDao {
    Account selectActByActno(String actno);
    int updateActByActno(Account act);
}
