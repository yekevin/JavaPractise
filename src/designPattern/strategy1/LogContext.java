package designPattern.strategy1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class LogContext {

    private LogStrategy dbLogStrategy = new DBStrategy();
    private LogStrategy fileLogStrategy = new FileLogStrategy();

    public void log(String msg) {
        try {
            dbLogStrategy.log(msg);
        } catch (Exception e) {
            fileLogStrategy.log(msg);
        }
    }
}
