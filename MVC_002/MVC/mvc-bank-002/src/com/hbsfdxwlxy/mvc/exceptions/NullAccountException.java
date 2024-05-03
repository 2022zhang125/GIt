package com.hbsfdxwlxy.mvc.exceptions;

/**
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 *
 * 账户不存在
 */
public class NullAccountException extends Exception{
    public NullAccountException() {

    }
    public NullAccountException(String msg){
        super(msg);
    }
}
