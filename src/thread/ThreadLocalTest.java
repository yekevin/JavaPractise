package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Kevin
 * @description 简单的耗时计算
 * @date 2017/2/28
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Long> timeThreadLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost:" + ThreadLocalTest.end() + " mills");
    }

    public static final void begin() {
        timeThreadLocal.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - timeThreadLocal.get();
    }
}
