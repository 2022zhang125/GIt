package com.hbsfdxwlxy.mvc.service;

import com.hbsfdxwlxy.mvc.exceptions.AppErrorException;
import com.hbsfdxwlxy.mvc.exceptions.MoneyNotEnoughException;
import com.hbsfdxwlxy.mvc.exceptions.NullAccountException;

public interface AccountService {
    void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, AppErrorException, NullAccountException;
}
