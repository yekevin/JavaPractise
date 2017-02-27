package designPattern.flyweight;

/**
 * @author Kevin
 * @description 利用共享技术有效的支持大量的细粒度对象
 * @date 2017/2/16
 */
public class Client {

    public static void main(String[] args) {
        SecurityMgr mgr = SecurityMgr.getInstance();
        mgr.login("张三");
        mgr.login("李四");
        boolean f1 = mgr.hasPermit("张三","薪资数据","查看");
        boolean f2 = mgr.hasPermit("李四","薪资数据","查看");

        System.out.println("f1=="+f1);
        System.out.println("f2=="+f2);
        for(int i=0;i<3;i++){
            mgr.login("张三"+i);
            mgr.hasPermit("张三"+i,"薪资数据","查看");
        }
    }
}
