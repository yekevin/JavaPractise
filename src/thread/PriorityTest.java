package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Kevin
 * @description
 * @date 2017/2/27
 */
public class PriorityTest {

    private static CyclicBarrier barrier = new CyclicBarrier(10);

    private volatile static boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(barrier, priority);
            jobs.add(job);
            Thread t = new Thread(job, "Thread - " + i);
            t.setPriority(priority);
            t.start();
        }
        Thread.sleep(3000);
        notEnd = false;
        for (int i = 0, size = jobs.size(); i < size; i++) {
            System.out.println("Job priority : " + jobs.get(i).priority + ",Job counts : " + jobs.get(i).count);
        }
    }

    private static class Job implements Runnable {
        private long count;
        private int priority;
        private CyclicBarrier barrier;

        public Job(CyclicBarrier barrier, int priority) {
            this.barrier = barrier;
            this.priority = priority;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wating...");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " start...");
            while (notEnd) {
                Thread.yield();
                this.count++;
            }
        }
    }
}
