package thread;

/**
 * @author Kevin
 * @description sleep等方法在抛出InterruptedException之前，java虚拟机会先将该线程的中断标识位清除
 * @date 2017/2/28
 */
public class InterruptedTest {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        Thread.sleep(5000);

        sleepThread.interrupt();
        busyThread.interrupt();
        // false
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        // true
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

    }

    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
