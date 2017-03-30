package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description 无参数方法定义时，使用泛型
 * 方法的返回值前面，修饰符后面增加，表示为泛型方法。这样，就可以在方法的代码中使用T代表类型。
 * 没有参数的泛型方法，类型的确定，是根据等号左边的类型推导泛型的最终类型。
 * @date 2017/3/30
 */
public class NoParamMethodDefineTest {

    public <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        NoParamMethodDefineTest noParamMethodDefine = new NoParamMethodDefineTest();
        // 根据等号左边的类型推到泛型最终类型
        List<String> strings = noParamMethodDefine.newArrayList();
        strings.add("Hello");
        strings.add("World");
        System.out.println(strings);

        List<Integer> integers = noParamMethodDefine.newArrayList();
        integers.add(1);
        integers.add(2);
        System.out.println(integers);
    }
}
