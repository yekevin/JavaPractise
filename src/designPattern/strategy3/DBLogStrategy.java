package designPattern.strategy3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class DBLogStrategy extends LogStrategyTemplate {

    @Override
    protected void doLog(String msg) {
        if (msg != null && msg.length() > 15) {
            int i = 5 / 0;
        }
        System.out.println("Log to database:" + msg);
    }
}
