package test.java;

import com.puhui.utils.HttpUtils;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by wentong on 2016/3/29.
 * Http 的测试类
 */
public class TestHttp {
    @Test
    public void testGet() throws IOException {
        String url = "http://localhost:8080/test/testGet?username=zhangsan";
        HttpUtils.sendGet(url);
    }

    @Test
    public void testPost() throws IOException {
        String url = "http://localhost:8080/test/testPost";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "周文童");
        HttpUtils.sendPost(url,jsonObject.toString());
    }
}
