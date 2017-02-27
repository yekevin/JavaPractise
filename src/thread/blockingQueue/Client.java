package thread.blockingQueue;

/**
 * @author Kevin
 * @description 用Java实现阻塞队列。
 * @date 2017/2/24
 */
public class Client {

    private static JavaBlockingQueue<Integer> queue = new JavaBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        queue.put(i);
                        System.out.println("put a element into queue");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    int result = 0;
                    try {
                        result = queue.get();
                        System.out.println(result);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        producer.start();
        consumer.start();
    }
}
