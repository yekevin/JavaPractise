package designPattern.strategy2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class BankPayStrategy2 implements PayStrategy {
    private String account;

    public BankPayStrategy2(String account) {
        this.account = account;
    }

    @Override
    public void pay(PayContext payContext) {
        System.out.println("pay to " + payContext.getName() + " with money " + payContext.getMoney() + " with account " + this.account);
    }
}
