package com.hbsfdxwlxy.mvc.exceptions;

/**
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 *
 * APP错误异常
 */
public class AppErrorException extends Exception{
    public AppErrorException() {
    }
    public AppErrorException(String msg){
        super(msg);
    }
}
