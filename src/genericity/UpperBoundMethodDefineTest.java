package genericity;

/**
 * @author Kevin
 * @description 使用上界通配符
 * @date 2017/3/30
 */
public class UpperBoundMethodDefineTest {

    // 表示传入的类型必须是Number或者其子类型。
    public <T extends Number> void show(T t) {
        System.out.println(t.getClass());
    }

    public static void main(String[] args) {
        UpperBoundMethodDefineTest upperBoundMethodDefine = new UpperBoundMethodDefineTest();
        upperBoundMethodDefine.show(123);
        upperBoundMethodDefine.show(123L);
        upperBoundMethodDefine.show(123F);
    }
}
