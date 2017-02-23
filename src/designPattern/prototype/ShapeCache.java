package designPattern.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class ShapeCache {
    private static Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(String id) {
        Shape shape = shapeMap.get(id);
        return shape == null ? null : (Shape) shape.clone();
    }

    public static void loadCache() {
        Shape cycle = new Cycle();
        cycle.setId("1");
        shapeMap.put(cycle.getId(),cycle);

        Shape retangle = new Retangle();
        retangle.setId("2");
        shapeMap.put(retangle.getId(),retangle);
    }
}
