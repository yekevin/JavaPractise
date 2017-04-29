package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Administrator
 * @description
 * @date 2017/4/29
 */
public class ReflectApplication {

    public static void main(String[] args) throws Exception {
        putStringToIntegerList();
        changeArrayData();
        changeArrayLength();
    }

    // 通过反射机制扩张数组的大小
    private static void changeArrayLength() {
        int[] temp = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] newTemp = (int[]) arrayInc(temp, 15);
        print(newTemp);
        String[] atr = { "a", "b", "c" };
        String[] str1 = (String[]) arrayInc(atr, 8);
        print(str1);
    }

    // 修改数组大小
    public static Object arrayInc(Object obj, int len) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, len);
        int co = Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }

    // 打印
    public static void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }
        System.out.println("数组长度为： " + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
        System.out.println();
    }

    // 通过反射取得并修改数组的信息
    private static void changeArrayData() {
        int[] temp = { 1, 2, 3, 4, 5 };
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型:" + demo.getName());
        System.out.println("数组长度:" + Array.getLength(temp));
        System.out.println("数组的第一个元素:" + Array.get(temp,0));
        Array.set(temp,0,100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
    }

    // 在泛型为Integer的ArrayList中存放一个String类型的对象。
    private static void putStringToIntegerList() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list, "Java反射机制");
        System.out.println(list.get(0));
    }
}
