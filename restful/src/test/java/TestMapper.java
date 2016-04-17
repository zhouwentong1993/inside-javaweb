import com.puhui.demo.mapper.RestfulUserMapper;
import com.puhui.demo.vo.RestfulUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by wentong on 2016/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class TestMapper {
    @Autowired
    private RestfulUserMapper restfulUserMapper;

    @Test
    public void test() {
//        RestfulUser userById = restfulUserMapper.getUserById((long) 1);
//        System.out.println(userById);
        RestfulUser user = new RestfulUser();
        user.setAddress("address");
        user.setName("name");
        user.setPassword("password");
        user.setSex(1);
        restfulUserMapper.insertUser(user);
    }
}
