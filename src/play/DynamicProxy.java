package play;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Stack;

/**
 * @author Kevin
 * @description
 * @date 2017/3/8
 */
public class DynamicProxy implements InvocationHandler {

    private Object source;

    public DynamicProxy(Object source) {
        super();
        this.source = source;
        Stack stack = new Stack();
        stack.peek();
        stack.pop();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("接口的方法全部变成这样了");
        // source 未实现接口 调用则发生异常
//        method.invoke(proxy, args);

        // 通过反射也可以调用
//        Method method1 = source.getClass().getDeclaredMethod(method.getName(),method.getParameterTypes());
//        method1.setAccessible(true);
//        method1.invoke(source,args);
        return null;
    }

    public static void main(String[] args) throws IOException {
        //只要你传入就可以强转成功
        TestInterface object = (TestInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{TestInterface.class}, new DynamicProxy(new TestClass()));
        object.method1();
        object.method2();
        object.method3();

        byte[] byteClass = ProxyGenerator.generateProxyClass("TestProxy", new Class[]{TestInterface.class});
        File file = new File("F:/TestProxy.class");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteClass);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
