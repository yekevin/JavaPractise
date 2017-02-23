package designPattern.proxy2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class Client {

    public static void main(String[] args) {
        OrderApi order = new OrderProxy(
                new Order("设计模式", "张三", 100));
        order.setOrderNum(123, "李四");
        System.out.println("李四修改后订单记录没有变化："+order);

        order.setOrderNum(123, "张三");
        System.out.println("张三修改后，订单记录："+order);
    }
}
