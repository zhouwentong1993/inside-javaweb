package com.puhui.exception;

/**
 * Created by wentong on 2016/4/25.
 */
public class MyException1 extends RuntimeException {
    @Override
    public String getMessage() {
        System.out.println("This is MyException1");
        return super.getMessage();
    }

    public MyException1(String message) {
        super(message);
    }
}
