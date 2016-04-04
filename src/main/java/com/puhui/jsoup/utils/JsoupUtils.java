package com.puhui.jsoup.utils;

import com.puhui.jsoup.constants.Constants;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by wentong on 2016/4/4.
 * Jsoup 工具类
 */
@Component
public final class JsoupUtils {

    private JsoupUtils() {
    }

    private static JsoupUtils instance = new JsoupUtils();

    public static JsoupUtils getInstance() {
        return instance;
    }

    /**
     * 将内容写入到文件中去
     *
     * @param name 姓名
     * @param star 星级
     */
    public void writeFile(String name, String star) {
        File file = new File("E:\\douban.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(file, true);
            // 换行符
            String crlf = System.getProperty("line.separator");
            writer.write(star + "   " + name + crlf);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getDoubanReview() {
        try {
            //只得到1-5页数据
            for (int i = 0; i < 5; i++) {
                String url = Constants.URL + Constants.START + String.valueOf(i * Constants.NUM);
                System.out.println(url);
                Connection connection = Jsoup.connect(url);
                Document document = connection.get();
                Elements ul = document.select("ul"); // 得到ul标签
                for (Element element : ul) {
                    Elements eleLi = element.select("li.clst*"); // 得到ul里的li.clst*标签
                    for (Element liElement : eleLi) {
                        Elements eleSpan = liElement.select("span.pl*"); // 得到ul里的li.clst*里span.pl*的标签
                        Elements eleHref = eleSpan.select("a[href]");
                        String name = eleHref.text().substring(eleHref.text().indexOf("《"));
                        Elements eleStar = eleSpan.select("span[title]");
                        String star = eleStar.attr("title");
                        System.out.println(name + " " + star);
                        System.out.println("写入文件开始");
                        JsoupUtils.getInstance().writeFile(name, star); //写入文件
                        System.out.println("写入文件结束");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
