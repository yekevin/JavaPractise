package thread.notify;

/**
 * @author Kevin
 * @description
 * @date 2017/1/18
 */
public class RebalanceService extends ServiceThread {

    private static long WaitInterval = 20000;

    @Override
    public void run() {
        while (!this.isStoped()) {
            // 等待20s是或被唤醒
            this.waitForRunning(WaitInterval);
            System.out.println("rebalance run...");
        }
    }

    @Override
    public String getServiceName() {
        return RebalanceService.class.getSimpleName();
    }
}