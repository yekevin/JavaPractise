package designPattern.strategy3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class LogContext {
    private LogStrategy fileLogStrategy = new FileLogStrategy();
    private LogStrategy dbLogStrategy = new FileLogStrategy();

    public void log(String msg) {
        try {
            dbLogStrategy.log(msg);
        } catch (Exception e) {
            fileLogStrategy.log(msg);
        }
    }
}
