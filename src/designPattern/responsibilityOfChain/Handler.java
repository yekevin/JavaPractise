package designPattern.responsibilityOfChain;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * @param user 申请人
     * @param fee 申请费用
     */
    public abstract void handleRequest(String user,double fee);
}
