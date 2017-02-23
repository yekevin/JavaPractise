package designPattern.strategy3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class FileLogStrategy extends LogStrategyTemplate {
    @Override
    protected void doLog(String msg) {
        System.out.println("Log to File:" + msg);
    }
}
