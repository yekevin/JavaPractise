package designPattern.command3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class CookManager {

    private static volatile boolean running = false;

    public synchronized static void run() {
        if (!running) {
            running = true;
        }

        HotCook hotCook1 = new HotCook("张三");
        HotCook hotCook2 = new HotCook("李四");
        HotCook hotCook3 = new HotCook("王五");

        new Thread(hotCook1).start();
        new Thread(hotCook2).start();
        new Thread(hotCook3).start();
    }
}
