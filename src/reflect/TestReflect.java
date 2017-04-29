package reflect;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Administrator
 * @description
 * @date 2017/4/29
 */
public class TestReflect implements Serializable {

    private String name;
    private int age;

    public void reflect1() {
        System.out.println("TestReflect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}');
    }

    public void reflect2(String name,int age) {
        System.out.println("TestReflect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}');
    }

    public static void main(String[] args) throws Exception {
        getPackageName();
        instanceClass();
        getSuperclasses();
        instanceObject();
        getClassFields();
        getClassFields();
        getClassMethods();
        callMethod();
        optClassField();
    }

    private static void optClassField() throws Exception{
        Class<?> clazz = Class.forName("reflect.TestReflect");
        Object obj = clazz.newInstance();
        // 可以直接对private的属性赋值
        Field field= clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(obj,"Name Changed");
        System.out.println(field.get(obj));
    }

    // 通过反射机制调用某个类的方法
    private static void callMethod() throws Exception{
        Class<?> clazz = Class.forName("reflect.TestReflect");
        // 调用TestReflect类中的reflect1方法
        Method method = clazz.getMethod("reflect1");
        method.invoke(clazz.newInstance());

        //  调用TestReflect的reflect2方法
        method = clazz.getMethod("reflect2",String.class,int.class);
        method.invoke(clazz.newInstance(),"Kevin",20);
    }

    // 获取某个类的全部方法
    private static void getClassMethods() throws Exception {
        Class<?> clazz = Class.forName("reflect.TestReflect");
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Class<?> returnType = methods[i].getReturnType();
            Class<?>[] params = methods[i].getParameterTypes();
            int temp = methods[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + " ");
            System.out.print(methods[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < params.length; j++) {
                System.out.print(params[j].getName() + " " + "arg" + j);
                if (j < params.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(")");
            Class<?> exce[] = methods[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(" throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            }
            System.out.println();
        }
    }

    // 获取某个类的全部属性

    private static void getClassFields() throws Exception {
        Class<?> clazz = Class.forName("reflect.TestReflect");
        // 取得本类全部属性
        System.out.println("===============本类属性===============");
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            // 权限修饰符
            int mod = fields[i].getModifiers();
            String priv = Modifier.toString(mod);
            // 属性类型
            Class<?> type = fields[i].getType();
            System.out.println(priv + " " + type.getName() + " " + fields[i].getName() + ";");
        }

        // 实现的接口或父类的属性
        System.out.println("==========实现的接口或者父类的属性==========");
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mod = filed1[j].getModifiers();
            String priv = Modifier.toString(mod);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }
    }

    // 通过反射机制实例化一个类的对象
    private static void instanceObject() throws Exception {
        Class<?> class1 = null;
        class1 = Class.forName("reflect.User");

        // 第一种方法，实例化默认构造方法，调用set赋值
        User user = (User) class1.newInstance();
        user.setAge(20);
        user.setName("Kevin");
        System.out.println(user);

        // 第二种方法 取得全部构造函数，使用构造函数赋值
        Constructor<?> cons[] = class1.getConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class<?> clazz[] = cons[i].getParameterTypes();
            System.out.print("cons[" + i + "](");
            for (int j = 0; j < clazz.length; j++) {
                if (j == clazz.length - 1) {
                    System.out.print(clazz[j].getName());
                } else {
                    System.out.print(clazz[j].getName() + ",");
                }
            }
            System.out.println(")");
        }
    }

    // 实例化Class类对象
    private static void instanceClass() throws Exception {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;

        class1 = Class.forName("reflect.TestReflect");
        class2 = new TestReflect().getClass();
        class3 = TestReflect.class;

        System.out.println("类名称 " + class1.getName());
        System.out.println("类名称 " + class2.getName());
        System.out.println("类名称 " + class3.getName());
    }

    // 通过一个对象获得完整的包名和类名
    private static void getPackageName() {
        TestReflect reflect = new TestReflect();
        System.out.println(reflect.getClass().getName());
    }

    // 获取一个对象的父类与实现的接口
    private static void getSuperclasses() throws Exception {
        Class<?> clazz = Class.forName("reflect.TestReflect");
        // 取得父类
        Class<?> parentClass = clazz.getSuperclass();
        // clazz 父类为 java.lang.Object
        System.out.println("clazz的父类为 " + parentClass.getName());

        // 获取所有的接口
        Class<?> interfaces[] = clazz.getInterfaces();
        System.out.println("clazz实现的接口有：");
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println((i + 1) + "：" + interfaces[i].getName());
        }
        // clazz实现的接口有：
        // 1：java.io.Serializable
    }
}
