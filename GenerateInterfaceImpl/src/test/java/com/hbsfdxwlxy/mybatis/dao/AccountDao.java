package com.hbsfdxwlxy.mybatis.dao;

import com.hbsfdxwlxy.mybatis.pojo.Account;

public interface AccountDao {
    // 查
    Account selectActByActno(String actno);
    // 改
    int updateActByActno(Account act);
}
