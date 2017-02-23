package designPattern.brige;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class MessageSms implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用站内信方式发送消息：" + message + " 给 " + toUser);
    }
}
