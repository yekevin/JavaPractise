package designPattern.brige;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public abstract class AbstractMessage {
    private MessageImplementor messageImplementor;

    public AbstractMessage(MessageImplementor messageImplementor) {
        this.messageImplementor = messageImplementor;
    }

    public void sendMessage(String message,String toUser){
        this.messageImplementor.send(message,toUser);
    }
}
