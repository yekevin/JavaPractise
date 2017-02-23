package designPattern.strategy2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class RMBPayStrategy implements PayStrategy {
    @Override
    public void pay(PayContext payContext) {
        System.out.println("pay rmb to " + payContext.getName() + " with " + payContext.getMoney());
    }
}
