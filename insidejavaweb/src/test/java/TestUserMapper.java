import com.puhui.mapper.UserMapper;
import com.puhui.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * Created by wentong on 2016/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;

    // sql inject
    @Test
    public void test1() {
        User user1 = new User();
        user1.setUsername("user2");
        String username = "张";
        List<User> userList = userMapper.queryUserByUserName(username, user1);
        userList.forEach(System.out::println);

        Optional.ofNullable(userList).orElseThrow(() -> new RuntimeException("有瑕疵"));
//        System.out.println(userList.getUsername());
    }

    @Test
    public void test2() {
        User user1 = new User();
        user1.setUsername("user1");
        User user2 = new User();
        user1.setUsername("user2");
        User user = userMapper.queryUserByUserName1(user1, user2);
        System.out.println(user.getUsername());
        System.out.println("");
    }
}
