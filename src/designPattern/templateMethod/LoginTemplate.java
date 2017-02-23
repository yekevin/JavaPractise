package designPattern.templateMethod;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public abstract class LoginTemplate {

    public boolean login(LoginModel loginModel) {
        LoginModel dbLm = this.getLoginModel(loginModel.getLoginId());
        if (dbLm != null) {
            loginModel.setPwd(this.encryptPwd(loginModel.getPwd()));
            return this.match(loginModel, dbLm);
        }
        return false;
    }

    protected abstract LoginModel getLoginModel(String loginId);

    protected boolean match(LoginModel lm, LoginModel dbLm) {
        if (lm.getLoginId().equals(dbLm.getLoginId()) && lm.getPwd().equals(dbLm.getPwd())) {
            return true;
        }
        return false;
    }

    protected String encryptPwd(String pwd) {
        return pwd;
    }
}
