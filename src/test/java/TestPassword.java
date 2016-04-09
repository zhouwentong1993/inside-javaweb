import com.puhui.password.CommonPassword;
import org.junit.Test;

/**
 * Created by wentong on 2016/4/8.
 * 密码测试类
 */
public class TestPassword {
    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            CommonPassword.getSalt();
        }
    }

    @Test
    public void test2() {
        CommonPassword.savePassword("123456");
    }
}
