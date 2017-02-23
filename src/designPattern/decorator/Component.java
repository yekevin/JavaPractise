package designPattern.decorator;

import java.util.Date;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public abstract class Component {

    public abstract double calcPrize(String user, Date begin, Date end);
}
