package designPattern.templateMethod;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class WorkerLogin extends LoginTemplate {
    @Override
    protected LoginModel getLoginModel(String loginId) {
        // select from work table
        LoginModel lm = new LoginModel();
        lm.setLoginId("1");
        lm.setPwd("pwd123456");
        return lm;
    }

    @Override
    protected String encryptPwd(String pwd) {
        return "pwd" + pwd;
    }
}
