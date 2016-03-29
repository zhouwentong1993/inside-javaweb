package com.puhui.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wentong on 2016/3/29.
 * Http 工具类
 */
public class HttpUtils {
    /**
     * 向指定地址发送 get 请求
     * @param urlParam 拼接之后的 url
     */
    public static void sendGet(String urlParam) throws IOException {


        URL url = new URL(urlParam);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            // get 请求
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println("================================");
            System.out.println("发送 GET 请求成功！");
            System.out.println("发送 URL 为：" + urlParam);
            System.out.println("返回响应码：" + responseCode);
            System.out.println("返回报文为：" + stringBuilder);
            System.out.println("================================");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 发送 POST 请求
     */
    public static void sendPost(String urlParam,String content) throws IOException {
        URL url = new URL(urlParam);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        // 向外发送请求
        urlConnection.setDoOutput(true);

        DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
//        dataOutputStream.writeUTF(content);
        dataOutputStream.writeBytes(content);
        dataOutputStream.flush();
        dataOutputStream.close();

        int responseCode = urlConnection.getResponseCode();
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        System.out.println("================================");
        System.out.println("发送 POST 请求成功！");
        System.out.println("发送 URL 为：" + urlParam);
        System.out.println("发送 Body 为：" + content);
        System.out.println("返回响应码：" + responseCode);
        System.out.println("返回报文为：" + stringBuilder);
        System.out.println("================================");
    }
}
