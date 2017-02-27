package designPattern.prototype;


/**
 * @author Kevin
 * @description 用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
 * @date 2017/2/11
 */
public class Client {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("1");
        System.out.println(shape);
    }
}
