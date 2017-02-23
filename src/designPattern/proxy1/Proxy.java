package designPattern.proxy1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class Proxy implements UserApi {
    private UserApi user;
    private volatile boolean loaded;

    public Proxy(UserApi user) {
        this.user = user;
    }

    @Override
    public String getId() {
        return user.getId();
    }

    @Override
    public void setId(String id) {
        user.setId(id);
    }

    @Override
    public String getName() {
        return user.getName();
    }

    @Override
    public void setName(String name) {
        user.setName(name);
    }

    @Override
    public int getAge() {
        if (!loaded) {
            reload();
            loaded = true;
        }
        return user.getAge();
    }

    @Override
    public void setAge(int age) {
        user.setAge(age);
    }

    @Override
    public String getDept() {
        if (!loaded) {
            reload();
            loaded = true;
        }
        return user.getDept();
    }

    @Override
    public void setDept(String dept) {
        user.setDept(dept);
    }

    private void reload() {
        System.out.println("重新查询获取完整用户数据");
        User fullUser = TempDB.getInstance().getUserById(user.getId());
        user.setAge(fullUser.getAge());
        user.setDept(fullUser.getDept());
    }
}
