package designPattern.proxy1;

import java.util.*;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class UserManager {


    public List<UserApi> getAll() {
        List<User> users = TempDB.getInstance().getAllUser();
        List<UserApi> apiList = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            Proxy proxy = new Proxy(new UserApiImpl());
            proxy.setId(users.get(i).getId());
            proxy.setName(users.get(i).getName());
            apiList.add(proxy);
        }
        return apiList;
    }

}
