package designPattern.decorator;

import java.util.Date;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class ConcreteComponent extends Component {
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        return 0;
    }
}
