package loadBalance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/1/17.
 */
public class IpMap {

    public static Map<String, Integer> serverMap = new HashMap<String, Integer>();

    static {
        serverMap.put("192.168.1.1", 1);
        serverMap.put("192.168.1.2", 2);
        serverMap.put("192.168.1.3", 3);
    }

    public static Map<String, Integer> copy() {
        return new HashMap<String, Integer>(serverMap);
    }
}
