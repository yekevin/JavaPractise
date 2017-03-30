package gc;

/**
 * @author Kevin
 * @description
 * @date 2017/3/2
 * Vm Args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 */
public class MinorGcTest {

    private static final int MB_1 = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * MB_1];
        byte[] allocation2 = new byte[2 * MB_1];
        byte[] allocation3 = new byte[2 * MB_1];
        byte[] allocation4 = new byte[4 * MB_1];    // 出现一次Minor GC
    }
}
