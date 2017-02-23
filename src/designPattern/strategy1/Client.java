package designPattern.strategy1;

/**
 * @author Kevin
 * @description  定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独 立于使用它的客户而变化。
 * @date 2017/2/13
 */
public class Client {
    public static void main(String[] args) {
        LogContext logContext = new LogContext();
        logContext.log("Hello");
        logContext.log("Hello World!");
    }
}
