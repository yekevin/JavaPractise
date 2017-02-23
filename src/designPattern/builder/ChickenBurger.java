package designPattern.builder;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "chickenBurger";
    }

    @Override
    public Float price() {
        return 35.0f;
    }
}
