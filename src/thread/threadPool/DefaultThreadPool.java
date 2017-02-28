package thread.threadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Kevin
 * @description
 * @date 2017/2/28
 */
public class DefaultThreadPool<E extends Runnable> implements ThreadPool<E> {
    // 最大工作线程数量
    private static final int MAX_WORKER_NUMBER = 10;
    // 默认工作线程数量
    private static final int DEFAULT_WORKER_NUMBER = 5;
    // 最小工作线程数量
    private static final int MIN_WORKER_NUMBER = 1;
    // 工作线程数量
    private int workerNum = DEFAULT_WORKER_NUMBER;
    // 任务队列
    private final LinkedList<E> jobs = new LinkedList<>();
    // 工作线程列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    // 线程编号
    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBER);
    }

    public DefaultThreadPool(int threadNum) {
        workerNum = threadNum > MAX_WORKER_NUMBER ? MAX_WORKER_NUMBER : threadNum < MIN_WORKER_NUMBER ? MIN_WORKER_NUMBER : threadNum;
        initializeWorkers(workerNum);
    }

    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    public void execute(E e) {
        if (e != null) {
            synchronized (jobs) {
                jobs.addLast(e);
                jobs.notify();
            }
        }
    }

    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if (num + this.workerNum > MAX_WORKER_NUMBER) {
                num = MAX_WORKER_NUMBER - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }


    class Worker implements Runnable {

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                E e = null;
                synchronized (jobs) {
                    //
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e1) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    e = jobs.removeFirst();
                }
                if (e != null) {
                    e.run();
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }
}
