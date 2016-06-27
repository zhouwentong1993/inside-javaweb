package com.puhui.compilers.utils;

/**
 * Created by wentong on 2016/6/27.
 */
public class CommonUtils {

    private CommonUtils() {
    }

    /**
     * 检测输入字符是否为数字或者是字母
     * @param c 输入字符
     * @return True Or false
     */
    public static boolean isNumberOrAlphabetic(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}
