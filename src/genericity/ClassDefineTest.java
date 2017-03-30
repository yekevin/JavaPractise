package genericity;

/**
 * @author Kevin
 * @description 在定义类的时候，我们可以使用泛型
 * 类名后面增加，说明是泛型类。T可以视为类型的占位符。泛型类的代码就可以使用这个占位符T。
 * @date 2017/3/30
 */
public class ClassDefineTest<T> {
    private T field;

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }

    public static void main(String[] args) {
        ClassDefineTest<String> classDefineTest = new ClassDefineTest();
        classDefineTest.setField("Hello World");
        System.out.println(classDefineTest.getField());
    }
}
