package designPattern.builder;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "vegBurger";
    }

    @Override
    public Float price() {
        return 25.0f;
    }
}
