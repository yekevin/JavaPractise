package designPattern.abstractFactory;

/**
 * @author Kevin
 * @description 提供一个创建一系列相关或互相依赖的对象接口，而无需指定它们的具体类
 * @date 2017/2/11
 */
public class Client {

    public static void main(String[] args) {
        AbstractFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        Text text = factory.createText();

        factory = new UnixFactory();
        button = factory.createButton();
        text = factory.createText();
    }
}
