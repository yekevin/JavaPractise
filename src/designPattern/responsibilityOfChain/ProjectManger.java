package designPattern.responsibilityOfChain;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class ProjectManger extends Handler {

    @Override
    public void handleRequest(String user, double fee) {
        if (fee < 500) {
            System.out.println("ProjecetManager accept " + user + " fee of " + fee);
        } else {
            if (this.successor != null) {
                successor.handleRequest(user, fee);
            }
        }
    }
}
