package com.puhui.io.demo;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created by wentong on 2016/3/9.
 */
public class CharacterTest2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String source = "这是一段中文，chinese";
        byte[] bytes = source.getBytes("UTF-8");
        String s = new String(bytes, "UTF-8");
        System.out.println(s);

        Charset charset = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = charset.encode("abc");

        String s1 = byteBuffer.toString();
        byte[] array = byteBuffer.array();
        String s2 = new String(array, "UTF-8");
        System.out.println(s2);
        System.out.println(s1.toString());
    }
}
