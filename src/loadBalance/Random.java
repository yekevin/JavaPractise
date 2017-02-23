package loadBalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/18.
 */
public class Random {

    public static String getServer() {
        Map<String, Integer> serverMap = IpMap.copy();
        Set<String> keySet = serverMap.keySet();
        List<String> servers = new ArrayList<String>();
        servers.addAll(keySet);
        java.util.Random random = new java.util.Random();
        return servers.get(random.nextInt(servers.size()));
    }
}
