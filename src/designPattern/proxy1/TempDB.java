package designPattern.proxy1;

import java.util.*;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class TempDB {

    private static Map<String, User> users = new HashMap<>();
    private static TempDB instance = new TempDB();

    static {
        // init data
        users.put("1", new User("1", "user1", 20, "dept1"));
        users.put("2", new User("2", "user2", 21, "dept1"));
        users.put("3", new User("3", "user3", 22, "dept1"));
    }

    public static TempDB getInstance() {
        return instance;
    }

    // 模式查询数据库 只返回id,name
    public List<User> getAllUser() {
        Collection<User> c = users.values();
        List<User> list = new ArrayList<>();
        for (User user : c) {
            User u = new User();
            u.setId(user.getId());
            u.setName(user.getName());
            list.add(u);
        }
        return list;
    }

    // 返回user全部属性
    public User getUserById(String id) {
        return users.get(id);
    }
}
