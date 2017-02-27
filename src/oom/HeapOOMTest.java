package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/27
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOMTest {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    private static class OOMObject {

    }
}
