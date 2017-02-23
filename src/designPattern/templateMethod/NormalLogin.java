package designPattern.templateMethod;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class NormalLogin extends LoginTemplate {
    @Override
    protected LoginModel getLoginModel(String loginId) {
        // select from normal table
        LoginModel lm = new LoginModel();
        lm.setLoginId("2");
        lm.setPwd("123456");
        return lm;
    }
}
