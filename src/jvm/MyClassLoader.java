package jvm;

import java.io.*;

/**
 * @author Kevin
 * @description
 * 通常情况下，我们都是直接使用系统类加载器。但是，有的时候，我们也需要自定义类加载器。
 * 比如应用是通过网络来传输 Java 类的字节码，为保证安全性，这些字节码经过了加密处理，
 * 这时系统类加载器就无法对其进行加载，这样则需要自定义类加载器来实现。
 * 自定义类加载器一般都是继承自 ClassLoader 类，从上面对 loadClass 方法来分析来看，
 * 我们只需要重写 findClass 方法即可。
 * @date 2017/3/9
 */
public class MyClassLoader extends ClassLoader {
    private String root;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream is = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length;
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader();
        // 由于双亲委托机制存在 被加载的class不能存放在类路径下
        classLoader.setRoot("F:\\");
        Class<?> testClass = null;
        try {
            testClass = classLoader.loadClass("sortIntegers.SortIntegers");
            Object object = null;
            object = testClass.newInstance();
            System.out.println(object.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
