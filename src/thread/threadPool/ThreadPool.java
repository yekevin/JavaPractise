package thread.threadPool;

/**
 * @author Kevin
 * @description
 * @date 2017/2/28
 */
public interface ThreadPool<E extends Runnable> {

    void execute(E e);

    void shutdown();

    void addWorkers(int num);

    int getJobSize();
}
