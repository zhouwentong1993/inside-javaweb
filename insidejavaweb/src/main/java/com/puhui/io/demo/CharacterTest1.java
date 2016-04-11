package com.puhui.io.demo;

import java.io.*;

/**
 * Created by wentong on 2016/3/9.
 * 字符和字节之间的转换，要注意一定要指定字符编码，因为如果不指定的话
 * 会使用默认编码，这在跨环境编程中容易出现错误。
 */
public class CharacterTest1 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\wentong\\text.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                boolean flag = file.createNewFile();
                if (!flag) {
                    System.out.println("Error create file,Please check your file system or your privilege!");
                    return ;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            boolean flag = file.delete();
            if (flag) {
                boolean newFile = file.createNewFile();
                if (!newFile) {
                    System.out.println("Error create file,Please check your file system or your privilege!");
                }
            }
        }
        OutputStreamWriter writer = null;
        String source = "这是一段中文，为了测试";
//        String character = "UTF-8";
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            writer = new OutputStreamWriter(outputStream);
            writer.write(source);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("写入文件成功。");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        char[] buf = new char[64];
        while ((len = inputStreamReader.read(buf)) != -1) {
            stringBuilder.append(buf, 0, len);
        }

        System.out.println(stringBuilder.toString());
        System.out.println("读取成功。");
    }
}
