package genericity;

/**
 * @author Kevin
 * @description 有参数方法定义时，使用泛型
 * @date 2017/3/30
 */
public class ParamMethodDefineTest {

    // 有参数的泛型方法，类型的确定，是根据参数类型自动推导。
    public <T> void showClass(T t){
        System.out.println(t.getClass());
    }

    public static void main(String[] args) {
        ParamMethodDefineTest paramMethodDefine = new ParamMethodDefineTest();
        paramMethodDefine.showClass("123");
        paramMethodDefine.showClass(123);
    }
}
