package designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class FlyweightFactory {

    private static FlyweightFactory factory = new FlyweightFactory();

    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    private FlyweightFactory() {
    }

    public static FlyweightFactory getInstance() {
        return factory;
    }

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightMap.get(key);
        if (flyweight == null) {
            flyweight = new AuthorizationFlyweight(key);
            flyweightMap.put(key, flyweight);
        }
        return flyweight;
    }
}
