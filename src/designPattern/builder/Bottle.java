package designPattern.builder;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "bottle";
    }
}
