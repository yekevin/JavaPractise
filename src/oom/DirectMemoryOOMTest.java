package oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Kevin
 * @description
 * @date 2017/2/27
 * VM Args:-Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOMTest {

    private static final int SIZE_1_MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(SIZE_1_MB);
        }
    }
}
