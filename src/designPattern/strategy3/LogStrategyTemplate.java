package designPattern.strategy3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public abstract class LogStrategyTemplate implements LogStrategy {

    @Override
    public void log(String msg) {
        String now = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss").format(new Date());
        msg = now + msg;
        doLog(msg);
    }

    // Template method
    protected abstract void doLog(String msg);
}
