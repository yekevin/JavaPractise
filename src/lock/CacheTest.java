package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Kevin
 * @description cache读写锁
 * @date 2017/2/28
 */
public class CacheTest {

    private static Map<String, Object> map = new HashMap<>();
    private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static Lock r = rwLock.readLock();
    private static Lock w = rwLock.writeLock();

    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

}
