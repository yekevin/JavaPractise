package designPattern.templateMethod;

/**
 * @author Kevin
 * @description 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中，
 * 模板方法使用子类可以不改变一个算法的结构(父类)即可重新定义该算法的某些特定步骤(子类)。
 * @date 2017/2/15
 */
public class Client {

    public static void main(String[] args) {
        LoginModel lm = new LoginModel();
        lm.setLoginId("1");
        lm.setPwd("123456");

        LoginTemplate normalLogin = new NormalLogin();
        boolean flag = normalLogin.login(lm);
        System.out.println("普通登录结果：" + flag);

        LoginTemplate workLogin = new WorkerLogin();
        flag = workLogin.login(lm);
        System.out.println("工作平台登录结果：" + flag);
    }
}
