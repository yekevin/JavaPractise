package designPattern.strategy2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class BankPayStrategy1 implements PayStrategy {
    @Override
    public void pay(PayContext payContext) {
        PayContext2 payContext2 = (PayContext2) payContext;
        System.out.println("pay to " + payContext2.getName() + " with money " + payContext2.getMoney() + " with account " + payContext2.getAccount());
    }
}
