package com.hbsfdxwlxy.mybatis.bank.exceptions;

/**
 * 转账失败的异常
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class TransferErrorException extends Exception{
    public TransferErrorException() {
    }

    public TransferErrorException(String message) {
        super(message);
    }
}
