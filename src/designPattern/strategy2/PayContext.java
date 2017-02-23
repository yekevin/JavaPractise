package designPattern.strategy2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class PayContext {
    private String name;
    private Double money;
    private PayStrategy payStrategy;

    public PayContext(String name, Double money, PayStrategy payStrategy) {
        this.name = name;
        this.money = money;
        this.payStrategy = payStrategy;
    }

    public void payNow() {
        this.payStrategy.pay(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public PayStrategy getPayStrategy() {
        return payStrategy;
    }

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }
}
