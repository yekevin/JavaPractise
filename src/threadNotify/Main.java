package threadNotify;

/**
 * @author Kevin
 * @description
 * @date 2017/1/18
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RebalanceService rebalanceService = new RebalanceService();
        rebalanceService.start();
        Thread.sleep(5000);
        // 唤醒线程 让线程立刻执行
        rebalanceService.wakeup();
        Thread.sleep(5000);
        rebalanceService.shutdown(true);
    }
}
