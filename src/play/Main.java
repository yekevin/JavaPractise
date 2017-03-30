package play;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Kevin
 * @description
 * @date 2017/2/7
 */
public class Main {
    public static void main(String[] args) {
//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
//        Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool();
//        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
//
//        Random random1 = new Random(100);
//        Random random2 = new Random(100);
//        System.out.println(random1.nextInt());
//        System.out.println(random2.nextInt());
//        Thread.interrupted();


        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.get();
        System.out.println(atomicBoolean.get());

        Comparable comparable;
        Comparator comparator;

//        Arrays.toString();
//        Arrays.deepToString();

        Map<String, String> map = new HashMap();
        map.entrySet().iterator();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        ScheduledThreadPoolExecutor s = new ScheduledThreadPoolExecutor(5);
        s.schedule(t, 10, TimeUnit.SECONDS);

        Timer timer = new Timer("timer");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

            }
        };
        timer.schedule(timerTask, 100);

        Main.add(1, 2);
        Main.add(1, 2.1);
        Main.add(1, "1");

        Main.<Integer>add(1, 2);
//        Main.<Integer>add(1,2.2);
        Main.<Number>add(1, 2.2);
    }


    public static <T> void add(T x, T y) {

    }
}


