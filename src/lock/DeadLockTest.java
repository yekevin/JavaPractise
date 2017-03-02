package lock;

/**
 * @author Kevin
 * @description
 * @date 2017/2/27
 * 避免死锁的几个常见方法：
 *   1：避免一个线程同时获取多个锁。
 *   2：避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源。
 *   3：尝试使用定时锁，使用lock.tryLock(timeout)来替代内部锁机制。
 *   4：对于数据库锁，加锁解锁必须在一个数据库连接里，否则会出现解锁失败。
 */
public class DeadLockTest {

    private static String A = "a";
    private static String B = "b";

    public static void main(String[] args) {
        new DeadLockTest().deadLock();
    }

    public void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("visit t1 thread...");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("visit t2 thread...");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
