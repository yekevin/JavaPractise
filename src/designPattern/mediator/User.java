package designPattern.mediator;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class User {
    private String userId;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean delUser() {
        DeptUserMediatorImpl mediator = DeptUserMediatorImpl.getInstance();
        return mediator.delUser(this.userId);
    }
}
