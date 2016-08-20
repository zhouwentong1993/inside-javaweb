package com.puhui.mapper;

import com.puhui.jsoup.vo.DouBanVo;
import org.springframework.stereotype.Repository;

/**
 * Created by wentong on 2016/4/4.
 * 豆瓣电影 Mapper 接口
 */
@Repository
public interface MovieMapper {
    void insertMovie(DouBanVo douBanVo);
}
