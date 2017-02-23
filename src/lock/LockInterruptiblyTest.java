package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Kevin
 * @description
 * @date 2017/1/13
 */
public class LockInterruptiblyTest {
    public static void main(String[] args) throws Exception {
        new LockInterruptiblyTest().lockInterruptiblyTest();
        new LockInterruptiblyTest().lockTest();
    }

    /**
     * 即使子线程已经被打断，但是子线程仍然在run，可见lock()方法并不关心线程是否被打断，甚至说主线程已经运行完毕，子线程仍然在block().
     *
     * @throws InterruptedException
     */
    public void lockTest() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }, "child threadNotify -1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000);
    }

    /**
     * 1.线程在请求lock并被阻塞时，如果被interrupt，则“此线程会被唤醒并被要求处理InterruptedException”。
     * 2.并且如果线程已经被interrupt，再使用lockInterruptibly的时候，此线程也会被要求处理interruptedException
     *
     * @throws InterruptedException
     */
    public void lockInterruptiblyTest() throws InterruptedException {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        }, "child threadNotify -1");
        t1.start();
        System.out.println(t1.getName() + " started.");
        Thread.sleep(5000);
        System.out.println("interrupt " + t1.getName() + " in main threadNotify.");
        t1.interrupt();
        Thread.sleep(1000);
    }
}
