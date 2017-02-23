package designPattern.decorator;

import java.util.Date;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public abstract class Decorator extends Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        return component.calcPrize(user, begin, end);
    }
}
