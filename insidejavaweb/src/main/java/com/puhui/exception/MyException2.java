package com.puhui.exception;

/**
 * Created by wentong on 2016/4/25.
 */
public class MyException2 extends RuntimeException {
    @Override
    public String getMessage() {
        System.out.println("This is MyException2");
        return super.getMessage();
    }

    public MyException2(String message) {

        super(message);
    }
}
