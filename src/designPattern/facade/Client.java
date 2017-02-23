package designPattern.facade;

/**
 * @author Kevin
 * @description 为子系统的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得子系统更加容易使用
 * @date 2017/2/14
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.generate();
    }
}
