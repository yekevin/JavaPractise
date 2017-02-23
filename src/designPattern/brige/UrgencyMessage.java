package designPattern.brige;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class UrgencyMessage extends AbstractMessage {

    public UrgencyMessage(MessageImplementor messageImplementor) {
        super(messageImplementor);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        // urgency message do something
        message = "紧急：" + message;
        super.sendMessage(message, toUser);
    }
}
