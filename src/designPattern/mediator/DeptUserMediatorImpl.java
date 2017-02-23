package designPattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class DeptUserMediatorImpl {

    private List<DeptUserModel> data = new ArrayList<>();

    private static DeptUserMediatorImpl instance = new DeptUserMediatorImpl();

    private DeptUserMediatorImpl() {
        initData();
    }

    public static DeptUserMediatorImpl getInstance() {
        return instance;
    }

    private void initData() {
        DeptUserModel d1 = new DeptUserModel();
        d1.setDeptUserId("du1");
        d1.setDeptId("d1");
        d1.setUserId("u1");
        data.add(d1);

        DeptUserModel d2 = new DeptUserModel();
        d2.setDeptUserId("du2");
        d2.setDeptId("d1");
        d2.setUserId("u2");
        data.add(d2);

        DeptUserModel d3 = new DeptUserModel();
        d3.setDeptUserId("du3");
        d3.setDeptId("d2");
        d3.setUserId("u3");
        data.add(d3);

        DeptUserModel d4 = new DeptUserModel();
        d4.setDeptUserId("du4");
        d4.setDeptId("d2");
        d4.setUserId("u4");
        data.add(d4);

        DeptUserModel d5 = new DeptUserModel();
        d5.setDeptUserId("du5");
        d5.setDeptId("d2");
        d5.setUserId("u1");
        data.add(d5);
    }

    public synchronized boolean delDept(String deptId) {
        List<DeptUserModel> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getDeptId().equalsIgnoreCase(deptId)) {
                temp.add(data.get(i));
            }
        }
        data.removeAll(temp);
        return true;
    }

    public synchronized boolean delUser(String userId) {
        List<DeptUserModel> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUserId().equalsIgnoreCase(userId)) {
                temp.add(data.get(i));
            }
        }
        data.removeAll(temp);
        return true;
    }

    public synchronized void showDeptUser(Dept dept) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getDeptId().equalsIgnoreCase(dept.getDeptId())) {
                System.out.println("部门编号=" + dept.getDeptId()
                        + "下面拥有人员，其编号是：" + data.get(i).getUserId());
            }
        }
    }

    public synchronized void showUserDept(User user) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUserId().equalsIgnoreCase(user.getUserId())) {
                System.out.println("人员编号=" + user.getUserId()
                        + "属于部门编号是：" + data.get(i).getDeptId());
            }
        }
    }

    public synchronized void changeDept(String userId, String oldDept, String newDept) {
        //
    }
}
