package designPattern.strategy2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class Client {
    public static void main(String[] args) {
        PayContext payContext = new PayContext("Kevin", 20000.0, new DollarPayStrategy());
        payContext.payNow();

        payContext = new PayContext("Windy", 20000.0, new RMBPayStrategy());
        payContext.payNow();

        payContext = new PayContext("Chris", 20000.0, new BankPayStrategy2("66666666666666"));
        payContext.payNow();

        PayContext2 payContext2 = new PayContext2("88888888888888", "Kevin", 20000.0, new BankPayStrategy1());
        payContext2.payNow();

    }
}
