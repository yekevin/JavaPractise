package designPattern.responsibilityOfChain;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class Client {

    public static void main(String[] args) {
        //先要组装职责链
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManger();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试
        h3.handleRequest("小李", 300);
        h3.handleRequest("小张", 300);

        h3.handleRequest("小李", 600);
        h3.handleRequest("小张", 600);

        h3.handleRequest("小李", 1200);
        h3.handleRequest("小张", 1200);
    }
}
