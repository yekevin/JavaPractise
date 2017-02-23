package designPattern.mediator;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class Client {

    public static void main(String[] args) {
        DeptUserMediatorImpl mediator = DeptUserMediatorImpl.getInstance();

        //准备要撤销的部门，仅仅需要一个部门编号
        Dept dep = new Dept();
        dep.setDeptId("d1");
        Dept dep2 = new Dept();
        dep2.setDeptId("d2");
        //准备用于测试的人员，也只需要一个人员编号
        User user = new User();
        user.setUserId("u1");

        System.out.println("撤销部门前：");
        mediator.showDeptUser(dep);

        dep.delDept();
        System.out.println("撤销部门后：");
        mediator.showDeptUser(dep);


        System.out.println("人员离职前：");
        mediator.showDeptUser(dep2);

        user.delUser();
        System.out.println("人员离职后：");
        mediator.showDeptUser(dep2);

    }
}
