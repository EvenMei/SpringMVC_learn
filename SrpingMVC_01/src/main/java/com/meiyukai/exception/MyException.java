package com.meiyukai.exception;

public class MyException extends Exception{
    private String  msg  = null;

    public MyException(String message, String msg) {
        super(message);
        this.msg = msg;
    }

    public MyException(String msg) {
        this.msg = msg;
    }

}
