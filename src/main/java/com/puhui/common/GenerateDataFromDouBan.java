package com.puhui.common;

import com.puhui.jsoup.constants.Constants;
import com.puhui.jsoup.vo.DouBanVo;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wentong on 2016/4/4.
 * 从豆瓣网获取电影数据
 */
public class GenerateDataFromDouBan {
    /**
     * 获取抓取的数据
     *
     * @param from 从第几页开始抓取
     * @param end  到第几页结束
     * @return List 中包含了结果
     */
    public static List<DouBanVo> getData(int from, int end) {
        List<DouBanVo> result = new ArrayList<>();
//        DouBanVo douBanVo;
        try {
            for (int i = 0; i < 5; i++) {
                String url = Constants.URL + Constants.START + String.valueOf(i * Constants.NUM);
                System.out.println(url);
                Connection connection = Jsoup.connect(url);
                Document document = connection.get();
                Elements ul = document.select("ul"); // 得到ul标签
                for (Element element : ul) {
                    DouBanVo douBanVo = new DouBanVo();
                    int j = 0;
                    Elements eleLi = element.select("li.clst*"); // 得到ul里的li.clst*标签
                    Elements tlstLi = element.select("li.nlst*"); // 得到ul里的li.clst*标签
                    for (Element liElement : eleLi) {
                        int k = 0;
                        Elements eleSpan = liElement.select("span.pl*"); // 得到ul里的li.clst*里span.pl*的标签
                        Elements eleHref = eleSpan.select("a[href]");
                        String name = eleHref.text().substring(eleHref.text().indexOf("《"));
                        Elements eleStar = eleSpan.select("span[title]");
                        String star = eleStar.attr("title");
                        System.out.println(name + " " + star);
                        douBanVo.setMovieName(name);
                        douBanVo.setScore(star);
                        douBanVo.setId((long) (i * ++k));
                        douBanVo.setCreateTime(new Date());
                    }
                    for (Element liElement : tlstLi) {
                        Elements h3 = liElement.select("h3");
                        Elements eleHref = h3.select("a");
                        String desc = eleHref.text();
                        douBanVo.setDescription(desc);
                    }
                    result.add(douBanVo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
