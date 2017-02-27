package thread.join;

/**
 * @author Kevin
 * @description 现在有T1、T2、T3三个线程，怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 * @date 2017/2/24
 */
public class Client {

    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 is running...");
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 is running...");
            }
        });

        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3 is running");
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
