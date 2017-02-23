package loadBalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/18.
 */
public class Hash {

    public static String getServer() {
        Map<String, Integer> serverMap = IpMap.copy();
        Set<String> keySet = serverMap.keySet();
        List<String> servers = new ArrayList<String>();
        servers.addAll(keySet);
        // request.getRemoteAddr();
        String remoteIp = "192.168.1.1";
        int hashCode = remoteIp.hashCode();
        return servers.get(hashCode % servers.size());
    }
}
