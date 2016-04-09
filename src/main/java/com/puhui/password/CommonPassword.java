package com.puhui.password;

import com.puhui.password.vo.PasswordVo;
import org.apache.commons.codec.digest.DigestUtils;

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
            for (int i = 0; i < 5; i++) {
                result += random.nextInt(10);
            }
            //生成的最终结果
            return result;
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

    public static void savePassword(String source) {
        PasswordVo passwordVo = new PasswordVo();
        String salt = getSalt();
        passwordVo.setSalt(salt);
        char[] saltChar = salt.toCharArray();
//        byte[] bytes = DigestUtils.md5(source);
        String s = DigestUtils.md5Hex(source);
        int position = getConsult(salt);
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length + 6];
        for (int i = 0; i < chars.length; i++) {
            if (i != position) {
                result[i] = chars[i];
            } else {
                for (int j = 0; j < 5; j++) {
                    result[position] = saltChar[j];
                }
            }
        }
//        Arrays.
    }

}
