package designPattern.strategy2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class PayContext2 extends PayContext {
    private String account;

    public PayContext2(String account, String name, Double money, PayStrategy payStrategy) {
        super(name, money, payStrategy);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
