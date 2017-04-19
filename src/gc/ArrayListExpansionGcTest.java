package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @description
 * @date 2017/4/19
 * Vm args:-Xmx500M -Xms500M -Xmn200M -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=90
 * GC输出观察 jstat -gcutil pid interval times
 * 触发Full GC jmap -histo:live pid 老年代被回收
 * 问题：以下代码加上vm参数将出现不断做CMS GC
 * 定位：ArrayList扩容使用System.arrayCopy的新数组由java层面构建，有可能分配在新生代，而老年代的字节数组引用了新生代的数组(跨代引用)
 * 解决：vm参数加 -XX:+CMSScanvengeBeforeRemark  在执行CMS GC前做一次Young GC
 */
public class ArrayListExpansionGcTest {

    public static void main(String[] args) {
        allocateMemory();
        try {
            Thread.sleep(100000);
        } catch (Exception e) {

        }
    }

    private static void allocateMemory() {
        List<byte[]> list = new ArrayList();
        int size = 1024 * 1024 * 480;
        int len = size / (20 * 1024);
        for (int i = 0; i < len; i++) {
            try {
                byte[] bytes = new byte[20 * 1024];
                list.add(bytes);
            } catch (java.lang.OutOfMemoryError e) {

            }
        }
    }
}
