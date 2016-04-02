import com.puhui.mapper.UserMapper;
import com.puhui.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wentong on 2016/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        User user1 = new User();
        user1.setUsername("user2");
        String username = "user1";
        User user = userMapper.queryUserByUserName(username,user1);
        System.out.println(user.getUsername());
        System.out.println("");
    }
    @Test
    public void test2() {
        User user1 = new User();
        user1.setUsername("user1");
        User user2 = new User();
        user1.setUsername("user2");
        User user = userMapper.queryUserByUserName1(user1,user2);
        System.out.println(user.getUsername());
        System.out.println("");
    }
}
