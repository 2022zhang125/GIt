package com.hbsfdxwlxy.mvc.dao;

import com.hbsfdxwlxy.mvc.pojo.Account;

import java.util.List;

public interface AccountDao {
    int insert(Account act);
    int deleteById(String id);
    int update(Account act);
    Account selectFromActno(String actno);
    List<Account> selectAll();
}
