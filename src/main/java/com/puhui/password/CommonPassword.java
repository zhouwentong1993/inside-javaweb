package com.puhui.password;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wentong on 2016/4/8.
 * 密码重构类
 */
public class CommonPassword {
    /**
     * 生成盐
     *
     * @return 盐
     */
    public static String getSalt() {
        try {

            Random random = new Random();
            //第一个元素
            int first = random.nextInt(9) + 1;
            String result = first + "";
            StringBuilder stringBuilder = new StringBuilder(first + "");
            for (int i = 0; i < 5; i++) {
//                result += random.nextInt(10);
                stringBuilder.append(random.nextInt(10));
            }
            //生成的最终结果
            return stringBuilder.toString();
        } catch (Exception e) {
            System.out.println("盐生成失败，取默认盐");
            return 320000 + "";
        }
    }

    /**
     * 根据盐生成插入位置
     * 盐解析成功，返回指定位置，盐解析失败，返回默认位置（开始处）
     *
     * @param salt 盐
     * @return 插入位置
     */
    public static int getConsult(String salt) {
        try {
            int position = Integer.parseInt(salt);
            return position % 32;
        } catch (Exception e) {
            System.out.println("盐生成错误，无法解析成整数。");
            return 0;
        }
    }

    public static String getPassword(String source, String salt) {
        System.out.println("生成的盐为：" + salt);
        String s = DigestUtils.md5Hex(source);
        System.out.println("第一次加密的结果为：" + s);
        int position = getConsult(salt);
        System.out.println("得到的余数为：" + position);
        String passwordFirst = getPasswordFirst(salt, s, position);
        String result = DigestUtils.md5Hex(passwordFirst);
        System.out.println("第二次加密的结果为：" + passwordFirst);
        System.out.println("最终加密的结果为：" + result);
        return result;
    }

    /**
     * 生成加密之后的密码
     *
     * @param salt           盐值
     * @param sourcePassword 原密码
     * @param position       插入位置
     */
    private static String getPasswordFirst(String salt, String sourcePassword, int position) {
        char[] chars = sourcePassword.toCharArray();
        char[] saltChar = salt.toCharArray();
        char[] before = Arrays.copyOfRange(chars, 0, position);
        char[] after = Arrays.copyOfRange(chars, position, chars.length);
        // 拼接之后的结果
        char[] result = new char[saltChar.length + before.length + after.length];
        int index = 0;
        for (; index < before.length; index++) {
            result[index] = before[index];
        }
        System.arraycopy(before, 0, result, 0, before.length);
        System.arraycopy(saltChar, 0, result, before.length, saltChar.length);
        System.arraycopy(after, 0, result, before.length + saltChar.length, after.length);
        System.out.println("最终的结果的长度为：" + result.length);
        for (char c : result) {
            System.out.print(c + " ");
        }

        System.out.println();
//        String s = Arrays.toString(result);
        String s = new String(result);
        System.out.println("==========================");
        System.out.println(s);
        System.out.println("==========================");
        return s;
    }

}
