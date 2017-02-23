package designPattern.mediator;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class Dept {
    private String deptId;
    private String deptName;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public boolean delDept() {
        DeptUserMediatorImpl mediator = DeptUserMediatorImpl.getInstance();
        return mediator.delDept(this.deptId);
    }
}
