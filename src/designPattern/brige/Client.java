package designPattern.brige;

/**
 * @author Kevin
 * @description 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * @date 2017/2/11
 */
public class Client {

    public static void main(String[] args) {
        MessageImplementor implementor = new MessageSms();
        AbstractMessage message = new CommonMessage(implementor);
        message.sendMessage("Hello World!", "Kevin");

        implementor = new MessageEmail();
        message = new UrgencyMessage(implementor);
        message.sendMessage("Hello Wolrd!", "Kevin");
    }
}
