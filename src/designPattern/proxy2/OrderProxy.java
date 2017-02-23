package designPattern.proxy2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class OrderProxy implements OrderApi {

    private OrderApi order;

    public OrderProxy(OrderApi order) {
        this.order = order;
    }


    @Override
    public String getProductName() {
        return order.getProductName();
    }

    @Override
    public void setProductName(String productName, String user) {
        if (user != null && user.equals(this.getOrderUser())) {
            order.setProductName(productName, user);
        } else {
            System.out.println("对不起" + user
                    + "，您无权修改订单中的产品名称。");
        }
    }

    @Override
    public int getOrderNum() {
        return order.getOrderNum();
    }

    @Override
    public void setOrderNum(int orderNum, String user) {
        if (user != null && user.equals(this.getOrderUser())) {
            order.setOrderNum(orderNum, user);
        } else {
            System.out.println("对不起" + user
                    + "，您无权修改订单中的订购数量。");
        }
    }

    @Override
    public String getOrderUser() {
        return order.getOrderUser();
    }

    @Override
    public void setOrderUser(String orderUser, String user) {
        if (user != null && user.equals(this.getOrderUser())) {
            order.setOrderUser(orderUser, user);
        } else {
            System.out.println("对不起" + user
                    + "，您无权修改订单中的订购人。");
        }
    }
}
