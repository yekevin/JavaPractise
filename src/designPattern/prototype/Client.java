package designPattern.prototype;


/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class Client {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("1");
        System.out.println(shape);
    }
}
