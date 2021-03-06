package consistentHash;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 不带虚拟节点的一致性Hash算法
 */
public class ConsistentHashingWithoutVirtualNode<S> {

    // key为节点hash值,value为节点对象信息
    private TreeMap<Long, S> sortNodes;
    // 真实节点
    private List<S> realNodes;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public ConsistentHashingWithoutVirtualNode(List<S> realNodes) {
        this.realNodes = realNodes;
        init();
    }

    private void init() {
        sortNodes = new TreeMap<>();
        for (int i = 0; i < realNodes.size(); i++) {
            final S nodeInfo = realNodes.get(i);
            sortNodes.put(getHash(nodeInfo.toString()), nodeInfo);
        }
    }

    public void addNode(S s) {
        lock.writeLock().lock();
        realNodes.add(s);
        init();
        lock.writeLock().unlock();
    }

    public void removeNode(S s) {
        lock.writeLock().lock();
        realNodes.remove(s);
        init();
        lock.writeLock().unlock();
    }

    /**
     * 得到应当路由到的结点
     */
    public S getNodeInfo(String key) {
        lock.readLock().lock();
        SortedMap<Long, S> tail = sortNodes.tailMap(getHash(key));
        if (tail.size() == 0) {
            S node = sortNodes.get(sortNodes.firstKey());
            lock.readLock().unlock();
            return node;
        }
        S node = tail.get(tail.firstKey());
        lock.readLock().unlock();
        return node;

    }


    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     */
    private long getHash(String str) {
        final long p = 16777619L;
        long hash = 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
}