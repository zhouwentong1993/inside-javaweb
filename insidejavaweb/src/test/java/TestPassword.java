package test.java;

import com.puhui.password.CommonPassword;
import com.puhui.utils.HttpUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

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

//    @Test
//    public void test2() {
//        for (int i = 0; i < 100; i++) {
////            CommonPassword.getPassword("123456");
//        }
//    }

    @Test
    public void test3() {
        char[] source = {'1', '2', '3', '4', '5', '6'};
        char[] chars = Arrays.copyOfRange(source, 0, 0);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }

    @Test
    public void testRegister() throws IOException {
        String url = "http://localhost:8080/password/savePassword?mobile=18893795070&password=zhou123456";
        HttpUtils.sendGet(url);
    }

    @Test
    public void testLogin() throws IOException{
        String url = "http://localhost:8080/password/checkPassword?mobile=18893795070&password=123456";
        HttpUtils.sendGet(url);
    }

    @Test
    public void testChangePassword() throws IOException{
        String url = "http://localhost:8080/password/changePassword?mobile=18893795070&password=zhou123456";
        HttpUtils.sendGet(url);
    }
}
