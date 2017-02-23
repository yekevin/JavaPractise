package designPattern.decorator;

import java.util.Date;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class MonthPrizeDecorator extends Decorator {
    public MonthPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user + "月度奖金" + prize);
        return money + prize;
    }
}
