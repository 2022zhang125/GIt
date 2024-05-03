package com.hbsfdxwlxy.mvc.exception;

/**
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 *
 * 余额不足异常
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException() {
    }
    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}
