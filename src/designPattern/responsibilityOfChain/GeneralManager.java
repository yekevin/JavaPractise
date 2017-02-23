package designPattern.responsibilityOfChain;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class GeneralManager extends Handler {
    @Override
    public void handleRequest(String user, double fee) {
        System.out.println("GeneralManager accept " + user + " fee of " + fee);
    }
}
