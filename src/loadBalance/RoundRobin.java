package loadBalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/17.
 */
public class RoundRobin {
    private static Integer pos = 0;

    public static String getServer() {
        Map<String, Integer> serverMap = IpMap.copy();
        Set<String> keySet = serverMap.keySet();
        List<String> servers = new ArrayList<String>();
        servers.addAll(keySet);
        String server = null;
        synchronized (pos) {
            if (pos > servers.size()) {
                pos = 0;
            }
            server = servers.get(pos);
            pos++;
        }
        return server;
    }
}
