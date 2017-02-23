package designPattern.decorator;

import java.util.Date;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class GroupPrizeDecorator extends Decorator {

    public GroupPrizeDecorator(Component component) {
        super(component);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        double group = 0.0;
        for (double d : TempDB.mapMonthSaleMoney.values()) {
            group += d;
        }
        double prize = group * 0.01;
        System.out.println(user + "团队奖金" + prize);
        return money + prize;
    }
}
