package designPattern.proxy1;

import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class Client {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        List<UserApi> users = userManager.getAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("用户编号：" + users.get(i).getId() + ",用户姓名：" + users.get(i).getName());
        }

        System.out.println("访问用户其他属性 延迟加载");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("用户编号：" + users.get(i).getId() + ",用户姓名：" + users.get(i).getName() + ",年龄：" + users.get(i).getAge() + ",部门ID：" + users.get(i).getDept());
        }
    }
}
