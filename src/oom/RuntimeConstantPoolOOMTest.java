package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 * JDK1.6 VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOMTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        long i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
