import com.puhui.exception.MyException1;
import org.junit.Test;

/**
 * Created by wentong on 2016/4/21.
 */
public class TestException {
    @Test
    public void test() {
        try {
            String s = "abc";
            int i = 1 / 0;
            throw new RuntimeException("抛出一个运行时异常");
//            System.out.println("haha~");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }

    @Test
    public void test1() {
        try {
            throw new MyException1("exception1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
