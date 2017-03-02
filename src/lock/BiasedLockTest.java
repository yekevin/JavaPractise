package lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Kevin
 * @description 偏向锁性能测试
 * 如果程序没有竞争，则取消之前已经取得锁的线程同步操作。也就是说，若某一锁被线程获取后，
 * 便进入偏向模式，当线程再次请求这个锁时，就无需再进行相关的同步操作了，从而节约了操作时间，
 * 如果在此之间有其他的线程进行了锁请求，则锁退出偏向模式
 * @date 2017/2/27
 * 开启偏向锁 VM Args:-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0 -Xmx512m -Xms512m
 * 禁止偏向锁 VM Args:-XX:-UseBiasedLocking -Xmx512m -Xms512m
 */
public class BiasedLockTest {

    public static List<Integer> vectorList = new Vector<>();
    public static List<Integer> arrayList = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        listTest(vectorList);
        vectorList.clear();
        Runtime.getRuntime().gc();
        Thread.sleep(3000);
        listTest(arrayList);
    }

    private static void listTest(List<Integer> list) {
        long begin = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while (count < 10000000) {
            list.add(startnum);
            startnum += 2;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
