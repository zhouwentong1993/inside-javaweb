
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
        HttpUtils.sendPost(url, jsonObject.toString());
    }

    @Test
    public void testRest() {
        Map user = new TestRestTemplate().getForObject("http://127.0.0.1:9090/api/v1/user/1", Map.class);
        System.out.println(user);
    }

    @Test
    public void test2() throws IOException {
        while (true) {
            String url = "http://localhost:8080/test/insertValue";
            HttpUtils.sendGet(url);
        }
    }

    @Test
    public void testValue() {
        String url = "http://localhost:8080/test/insertValue";
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        HttpUtils.sendGet(url);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hthttt");
                }
            }, "name : " + i).start();
        }
    }

    @Test
    public void testWealthApp() {
        String token = "00CE8A84F0510478AE9A029503E8090F4FF061D7A35D30B63C111855F2D7916D053AE5391B9BF9BE8F6D031B4310EC79D26C5D24B8094B6771DE62FF8B6979B9DAA241E1AB4CE6EB58A2493A4FF4E4D7577132BF932A642666C4B67E515439BEP@HABEF154C6956777459A40C6DE259E6FAF";

    }
}
