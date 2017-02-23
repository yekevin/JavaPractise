package loadBalance;

import java.util.*;

/**
 * Created by Administrator on 2017/1/18.
 */
public class WeightRoundRobin {
    private static Integer pos = 0;

    public static String getServer() {
        Map<String, Integer> serverMap = IpMap.copy();
        Set<String> keySet = serverMap.keySet();
        List<String> servers = new ArrayList<String>();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                servers.add(server);
            }
        }
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
