package com.puhui.io.demo;

import org.apache.commons.codec.binary.Hex;

import java.math.BigDecimal;

/**
 * Created by wentong on 2016/3/14.
 * 编码和解码
 */
public class CharacterTest3 {
    private static String WORD = "I am 君山";
    public static void main(String[] args) throws Exception {
        BigDecimal bigDecimal = new BigDecimal(0);
        System.out.println(bigDecimal);

//        byte[] bytes1 = Hex.decodeHex(WORD.toCharArray());
//        for (byte b : bytes1) {
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        System.out.println("=======================");
//        char[] bytes = Hex.encodeHex(WORD.getBytes("ISO-8859-1"));
//        System.out.println("========char========");
//        for (char b : bytes) {
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        System.out.println("=====BYTE=====");
//        Charset charset = Charset.forName("ISO-8859-1");
//        ByteBuffer encode = charset.encode(CharBuffer.wrap(bytes));
//        byte[] array = encode.array();
//        for (byte b : array) {
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        System.out.println("===============================");
//
//        System.out.println();
//        byte[] temp = WORD.getBytes("ISO-8859-1");
//        for (byte c : temp) {
//            System.out.print(c + " ");
//        }

        byte[] bytes = Hex.decodeHex(WORD.toCharArray());
        String s = new String(bytes);
        System.out.println(s);
        byte[] bytes1 = WORD.getBytes("ISO-8859-1");
        for (byte b : bytes1) {
            System.out.print(b + " ");
        }
        System.out.println();
        System.out.println();
        char[] chars = Hex.encodeHex(bytes1);
        for (char c : chars) {
            System.out.print(c + " ");
        }
    }
}
