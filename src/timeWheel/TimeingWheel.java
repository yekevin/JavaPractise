package timeWheel;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Kevin
 * @description 时间轮算法
 * @date 2017/3/16
 */
public class TimeingWheel<E> {
    // tick时长 毫秒
    private final long tickDuration;
    // 一轮tick的数量
    private final int ticksPerWheel;
    // tick位置指针
    private volatile int currentTickIndex = 0;
    // 回调的listeners
    private final CopyOnWriteArrayList<ExpirationListener<E>> expirationListeners = new CopyOnWriteArrayList<>();
    // 循环列表中的槽集合
    private final ArrayList<Slot<E>> wheel;
    // 记录元素对应的槽
    private final Map<E, Slot<E>> indicator = new ConcurrentHashMap<E, Slot<E>>();
    // 线程状态
    private final AtomicBoolean shutdown = new AtomicBoolean(false);
    // 控制currentTickIndex读写
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    // 工作线程
    private Thread workerThread;

    public TimeingWheel(long tickDuration, int ticksPerWheel, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (tickDuration <= 0) {
            throw new IllegalArgumentException("tickDuration must be greater than 0: " + tickDuration);
        }
        if (ticksPerWheel <= 0) {
            throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + ticksPerWheel);
        }
        this.tickDuration = TimeUnit.MILLISECONDS.convert(tickDuration, timeUnit);
        this.ticksPerWheel = ticksPerWheel + 1;
        this.wheel = new ArrayList<>();

        // 初始化wheel上各个slot
        for (int i = 0; i < this.ticksPerWheel; i++) {
            wheel.add(new Slot<E>(i));
        }
        wheel.trimToSize();

        workerThread = new Thread(new TickWoker(), "TimingWheel-Thread");
    }

    public void start() {
        if (shutdown.get()) {
            throw new IllegalStateException("Cannot be started once stopped");
        }

        if (!workerThread.isAlive()) {
            workerThread.start();
        }
    }

    public boolean stop() {
        if (!shutdown.compareAndSet(false, true)) {
            return false;
        }

        boolean interrupted = false;
        while (workerThread.isAlive()) {
            workerThread.interrupt();
            try {
                workerThread.join(100);
            } catch (InterruptedException e) {
                interrupted = true;
            }
        }

        if (interrupted) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    // 添加监听器
    public void addExpirationListener(ExpirationListener<E> listener) {
        expirationListeners.add(listener);
    }

    // 移除监听器
    public void removeExpirationListener(ExpirationListener<E> listener) {
        expirationListeners.remove(listener);
    }

    // 添加元素
    public long add(E e) {
        synchronized (e) {
            checkAdd(e);
            int previousTickIndex = getPreviousTickIndex();
            // 取出对应的slot
            Slot<E> slot = wheel.get(previousTickIndex);
            slot.add(e);
            // 记录元素对应的slot
            indicator.put(e, slot);
            return (ticksPerWheel - 1) * tickDuration;
        }
    }

    // 检查该元素是否存在,存在就删除
    private void checkAdd(E e) {
        Slot<E> slot = indicator.get(e);
        if (slot != null) {
            slot.remove(e);
        }
    }

    // 获取上一次tick的位置
    private int getPreviousTickIndex() {
        lock.readLock().lock();
        try {
            int cti = currentTickIndex;
            if (cti == 0) {
                return ticksPerWheel - 1;
            }
            return cti - 1;
        } finally {
            lock.readLock().unlock();
        }
    }

    // 删除元素
    public boolean remove(E e) {
        synchronized (e) {
            Slot<E> slot = indicator.get(e);
            if (slot == null) {
                return false;
            }

            indicator.remove(e);
            return slot.remove(e);
        }
    }

    // 元素过期
    private void notifyExpired(int idx) {
        Slot<E> slot = wheel.get(idx);
        Iterator<E> iterator = slot.elemets().iterator();
        while (iterator.hasNext()) {
            E e = iterator.next();
            slot.remove(e);
            synchronized (e) {
                Slot<E> lastestSlot = indicator.get(e);
                if (lastestSlot.equals(slot)) {
                    indicator.remove(e);
                }
            }

            for (ExpirationListener<E> listener : expirationListeners) {
                listener.expired(e);
            }
        }
    }

    // 时间轮上的槽对象
    class Slot<E> {
        private long id;
        // 存储元素set
        private Set<E> elements = new HashSet<>();

        public Slot(long id) {
            this.id = id;
        }

        public void add(E e) {
            elements.add(e);
        }

        public boolean remove(E e) {
            return elements.remove(e);
        }

        public Set<E> elemets() {
            return elements;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Slot other = (Slot) obj;
            if (id != other.id) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Slot [id=" + id + ", elements=" + elements + "]";
        }
    }

    // 工作线程
    class TickWoker implements Runnable {

        private long startTime;
        private long tick;

        @Override
        public void run() {
            startTime = System.currentTimeMillis();
            tick = 1;

            for (int i = 0; !shutdown.get(); i++) {
                if (i == wheel.size()) {
                    i = 0;
                }
                lock.writeLock().lock();
                try {
                    currentTickIndex = i;
                } finally {
                    lock.writeLock().unlock();
                }
                notifyExpired(currentTickIndex);
                waitForNextTick();
            }
        }

        private void waitForNextTick() {
            for (; ; ) {
                long currentTime = System.currentTimeMillis();
                long sleepTime = tickDuration * tick - (currentTime - startTime);
                if (sleepTime <= 0) {
                    break;
                }

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    return;
                }
            }
            tick++;
        }
    }
}
