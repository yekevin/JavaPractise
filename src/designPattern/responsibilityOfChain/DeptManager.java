package designPattern.responsibilityOfChain;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class DeptManager extends Handler {
    @Override
    public void handleRequest(String user, double fee) {
        if (fee < 1000) {
            System.out.println("DeptManager accept " + user + " fee of " + fee);
        } else {
            if (this.successor != null) {
                successor.handleRequest(user, fee);
            }
        }
    }
}
