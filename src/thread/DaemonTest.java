package thread;

/**
 * @author Kevin
 * @description 守护线程：当虚拟机中没有非Daemon线程，虚拟机中的所有Daemon线程将立即终止
 * @date 2017/2/28
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread t = new Thread(new DaemonRunner(), "DaemonRunner");
        t.setDaemon(true);
        t.start();

    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally run.Never Show...");
            }
        }
    }
}
