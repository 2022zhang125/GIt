package com.hbsfdxwlxy.competition.managed.exceptions;

/**
 * 登录失败提醒
 */
public class LoginErrorException extends Exception{
    public LoginErrorException() {
    }

    public LoginErrorException(String message) {
        super(message);
    }
}
