package com.puhui.thread;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wentong on 2016/5/29.
 * 多线程下载
 */
public class MultipleThreadDownload {

    public static void main(String[] args) {
        String target = "D:";
        String source = "http://51reboot.com/src/blogimg/pc.jpg";
        int threadNumber = 5;
        new MultipleThreadDownload().download(target, source, threadNumber);
    }

    /**
     * 下载方法
     *
     * @param target       存储的文件名
     * @param source       下载的链接
     * @param threadNumber 线程数
     */
    private void download(String target, String source, int threadNumber) {
        try {
            URL url = new URL(source);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            // 如果资源存在
            if (200 == urlConnection.getResponseCode()) {
                System.out.println("文件资源正确，正在获取文件描述。");
                int contentLength = urlConnection.getContentLength();
                File file = new File(target + File.separator + getFileName(source));
                // 创建临时文件，使用读写模式
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(contentLength);
                System.out.println("临时文件创建完毕，文件大小为：" + contentLength);
                randomAccessFile.close();

                // 每一块下载多少。
                int block = contentLength % threadNumber == 0 ? contentLength / threadNumber : contentLength / threadNumber + 1;
                for (int threadId = 0; threadId < threadNumber; threadId++) {
                    new Thread(new DownloadThread(threadId, block, file, url)).start();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文件名称，根据下载下来的文件名称进行截取
     * @param source 下载 URL
     * @return 文件名称最后一个后缀
     */
    private String getFileName(String source) {
        if (null == source || source.trim().length() == 0) {
            return null;
        }
        return source.substring(source.lastIndexOf('/') + 1, source.length());
    }
}


/**
 * 下载线程
 */
class DownloadThread implements Runnable {

    int start;
    int end;
    int threadId;
    File file;
    URL url;

    public DownloadThread(int threadId, int block, File file, URL url) {
        this.start = block * threadId;
        this.end = block * (threadId + 1);
        this.threadId = threadId;
        this.file = file;
        this.url = url;
        System.out.println("第 " + threadId + " 个线程正在下载，从 " + start + " 到 " + end + " 处");
    }

    @Override
    public void run() {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            // 设置请求范围，从多少个字节请求到多少个字节
            urlConnection.setRequestProperty("Range", "bytes=" + start + "-" + end);

            if (206 == urlConnection.getResponseCode()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                // 将游标移动到开始位置
                System.out.println("将游标移动到：" + start + " 位置");
                randomAccessFile.seek(start);
                InputStream inputStream = urlConnection.getInputStream();
                byte[] buff = new byte[1024];
                int len;
                while ((len = inputStream.read(buff)) != -1) {
                    randomAccessFile.write(buff, 0, len);
                }
                System.out.println("文件写入成功。现在位置是：" + randomAccessFile.getFilePointer());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
