package genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description 方法定义时，使用通配符 ？
 * @date 2017/3/30
 */
public class WildcardMethodDefineTest {

    // 1、只能往集合中add null。
    // 2、因为集合中的类型不确定。因此，为了安全，转换为Object。
    public void show(List<?> list) {
        list.add(null);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        WildcardMethodDefineTest wildcardMethodDefine = new WildcardMethodDefineTest();
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        wildcardMethodDefine.show(strings);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        wildcardMethodDefine.show(integers);
    }
}
