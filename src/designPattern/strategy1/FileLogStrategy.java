package designPattern.strategy1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class FileLogStrategy implements LogStrategy {
    @Override
    public void log(String msg) {
        System.out.println("Log to File " + msg);
    }
}
