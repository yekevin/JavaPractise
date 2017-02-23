package designPattern.templateMethod;

/**
 * @author Kevin
 * @description
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
