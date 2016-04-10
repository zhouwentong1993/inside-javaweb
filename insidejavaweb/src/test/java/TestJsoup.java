package test.java;

import com.puhui.common.GenerateDataFromDouBan;
import com.puhui.jsoup.vo.DouBanVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wentong on 2016/4/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
public class TestJsoup {
    @Test
    public void test1() {
        List<DouBanVo> data = GenerateDataFromDouBan.getData(0, 5);
        data.forEach(System.out::println);
    }
}
