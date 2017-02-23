package designPattern.builder;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "coke";
    }

    @Override
    public Float price() {
        return 5.0f;
    }
}
