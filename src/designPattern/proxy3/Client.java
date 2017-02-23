package designPattern.proxy3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class Client {

    public static void main(String[] args) {
        OrderApi order = new Order("设计模式", "张三", 100);
        DynamicProxy proxy = new DynamicProxy();
        OrderApi orderProxy = proxy.getProxyInstance(order);
        orderProxy.setOrderNum(123, "李四");
        //输出order
        System.out.println("李四修改后订单记录没有变化：" + order);
        //张三修改就不会有问题
        orderProxy.setOrderNum(123, "张三");
        //再次输出order
        System.out.println("张三修改后，订单记录：" + order);
    }
}
