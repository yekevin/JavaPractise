package designPattern.proxy1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class UserApiImpl implements UserApi {
    private String id;
    private String name;
    private int age;
    private String dept;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getDept() {
        return dept;
    }

    @Override
    public void setDept(String dept) {
        this.dept = dept;
    }
}
