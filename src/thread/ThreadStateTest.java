package thread;


import java.util.concurrent.TimeUnit;

/**
 * @author Kevin
 * @description
 * @date 2017/2/27
 */
public class ThreadStateTest {

    public static void main(String[] args) {
        new Thread(new TimeWating(), "TimeWatingThread").start();
        new Thread(new Wating(), "WatingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }

    static class TimeWating implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtil.second(100);
            }
        }
    }

    static class Wating implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Wating.class) {
                    try {
                        Wating.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtil.second(100);
                }
            }
        }
    }


    static class SleepUtil {
        public static final void second(long seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
            }
        }
    }
}
