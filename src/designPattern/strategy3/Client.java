package designPattern.strategy3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class Client {
    public static void main(String[] args) {
        LogContext logContext = new LogContext();
        logContext.log("Hello");
        logContext.log("Hello World!");
    }
}
