/**
 * Created by wentong on 2016/7/3.
 * 测试按值传递
 */
public class PassParaByValueTest {
    public static void main(String[] args) {
        Value root = new Value("root");
        pass(root);
        System.out.println(root);
    }

    public static void pass(Value value) {
        value = new Value("pass");
    }
}

class Value {
    String name;

    public Value(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}