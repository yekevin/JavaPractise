package designPattern.builder;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "pepsi";
    }

    @Override
    public Float price() {
        return 5.0f;
    }
}
