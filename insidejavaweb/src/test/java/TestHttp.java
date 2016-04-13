package test.java;

import com.puhui.utils.HttpUtils;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;

import java.io.IOException;
import java.util.Map;

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

    @Test
    public void testRest() {
        Map user = new TestRestTemplate().getForObject("http://127.0.0.1:9090/api/v1/user/1", Map.class);
        System.out.println(user);
    }
}
