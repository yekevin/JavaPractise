package designPattern.mediator;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class DeptUserModel {
    private String deptUserId;
    private String deptId;
    private String userId;

    public String getDeptUserId() {
        return deptUserId;
    }

    public void setDeptUserId(String deptUserId) {
        this.deptUserId = deptUserId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
