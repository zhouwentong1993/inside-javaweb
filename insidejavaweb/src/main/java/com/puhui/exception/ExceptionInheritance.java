package com.puhui.exception;

/**
 * Created by wentong on 2016/6/13.
 * 两个异常为父子关系，catch 的时候如果先 catch 大的，会报错。
 */
public class ExceptionInheritance {
    public static void main(String[] args) {
        try {
            throw new FatherException();
        } catch (FatherException e) {
            e.printStackTrace();

        }
    }
}

class FatherException extends Exception {

}

class SonException extends FatherException {

}
