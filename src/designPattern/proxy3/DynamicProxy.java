package designPattern.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class DynamicProxy implements InvocationHandler {

    private OrderApi orderApi;

    public OrderApi getProxyInstance(OrderApi orderApi) {
        this.orderApi = orderApi;
        OrderApi orderApiProxy = (OrderApi) Proxy.newProxyInstance(orderApi.getClass().getClassLoader(), orderApi.getClass().getInterfaces(), this);
        return orderApiProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            //如果不是创建人，那就不能修改
            if (orderApi.getOrderUser() != null
                    && orderApi.getOrderUser().equals(args[1])) {
                //可以操作
                return method.invoke(orderApi, args);
            } else {
                System.out.println("对不起，" + args[1]
                        + "，您无权修改本订单中的数据");
            }
        } else {
            //不是调用的setter方法就继续运行
            return method.invoke(orderApi, args);
        }
        return null;
    }
}
