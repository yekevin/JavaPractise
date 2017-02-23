package loadBalance;

import java.util.*;
import java.util.Random;

/**
 * Created by Administrator on 2017/1/18.
 */
public class WeightRandom {

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
        Random random = new Random();
        return servers.get(random.nextInt(servers.size()));
    }
}
