package designPattern.builder;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
