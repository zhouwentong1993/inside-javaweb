import com.puhui.demo.vo.RestfulUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wentong on 2016/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
//@WebAppConfiguration
@WebIntegrationTest("server.port:9090")
//@DirtiesContext
public class Test1 {
    @Test
    public void test() {
        RestfulUser user = new TestRestTemplate().getForObject("http://127.0.0.1:8888/api/v1/user/1", RestfulUser.class);
        System.out.println(user);
    }
}
