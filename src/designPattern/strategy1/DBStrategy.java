package designPattern.strategy1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class DBStrategy implements LogStrategy {
    @Override
    public void log(String msg) {
        // make exception
        if (msg != null && msg.length() > 5) {
            int i = 1 / 0;
        }
        System.out.println("Log to database " + msg);
    }
}
