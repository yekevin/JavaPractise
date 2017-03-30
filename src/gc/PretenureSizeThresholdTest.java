package gc;

/**
 * @author Kevin
 * @description 大对象直接进入老年代
 * @date 2017/3/23
 * Args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3M
 */
public class PretenureSizeThresholdTest {

    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
}
