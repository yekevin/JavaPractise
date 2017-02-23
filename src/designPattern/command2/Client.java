package designPattern.command2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class Client {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        ChopCommand chopCommand = new ChopCommand();
        DuckCommand duckCommand = new DuckCommand();
        IceCommand iceCommand = new IceCommand();

        waiter.orderDish(chopCommand);
        waiter.orderDish(duckCommand);
        waiter.orderDish(iceCommand);

        waiter.orderOver();
    }
}
