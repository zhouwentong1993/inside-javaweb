package main.java.com.puhui.service.impl;

import com.puhui.jsoup.vo.DouBanVo;
import com.puhui.mapper.MovieMapper;
import com.puhui.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wentong on 2016/4/4.
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public void insertMovieInfo(DouBanVo douBanVo) {
        movieMapper.insertMovie(douBanVo);
    }
}
