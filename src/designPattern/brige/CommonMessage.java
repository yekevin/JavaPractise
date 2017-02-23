package designPattern.brige;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class CommonMessage extends AbstractMessage {

    public CommonMessage(MessageImplementor messageImplementor) {
        super(messageImplementor);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        // common message do something
        super.sendMessage(message, toUser);
    }
}
