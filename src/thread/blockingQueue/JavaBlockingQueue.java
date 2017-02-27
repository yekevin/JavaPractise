package thread.blockingQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Kevin
 * @description 用Java实现阻塞队列。
 * @date 2017/2/24
 */
public class JavaBlockingQueue<E> {
    // 队列容量
    private int limit;
    // 队列
    private List<E> data = new LinkedList<>();

    public JavaBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized boolean put(E e) throws InterruptedException {
        if (data.size() == this.limit) {
            this.wait();
        }
        if (data.size() > 0) {
            this.notifyAll();
        }
        return data.add(e);
    }

    public synchronized E get() throws InterruptedException {
        if (data.size() < limit) {
            this.notifyAll();
        }
        if (data.size() == 0) {
            this.wait();
        }
        return data.remove(0);
    }
}
