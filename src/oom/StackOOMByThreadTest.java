package oom;

/**
 * @author Kevin
 * @description
 * @date 2017/2/27
 * VM Args:-Xss2M
 */
public class StackOOMByThreadTest {

    public static void main(String[] args) {
        StackOOMByThreadTest oom = new StackOOMByThreadTest();
        oom.statckLeakByThread();
    }

    public void statckLeakByThread() {
        while (true) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            t.start();
        }
    }

    private void dontStop() {
        while (true) {
            // do nothing
        }
    }
}
