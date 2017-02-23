package designPattern.command3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class Client {
    public static void main(String[] args) {
        CookManager.run();

        for (int i = 0; i < 5; i++) {
            Waiter waiter = new Waiter();
            waiter.orderDish(new ChopCommand(String.valueOf(i)));
            waiter.orderDish(new DuckCommand(String.valueOf(i)));
            waiter.orderOver();
        }
    }
}
