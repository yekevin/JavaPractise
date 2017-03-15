package jvm;

/**
 * @author Kevin
 * @description
 * CPU为了提高处理性能，并不直接和内存进行通信，而是将内存的数据读取到内部缓存（L1，L2）再进行操作，
 * 但操作完并不能确定何时写回到内存，如果对volatile变量进行写操作，当CPU执行到Lock前缀指令时，会将这个变量所在缓存行的数据写回到内存，
 * 不过还是存在一个问题，就算内存的数据是最新的，其它CPU缓存的还是旧值，所以为了保证各个CPU的缓存一致性，
 * 每个CPU通过嗅探在总线上传播的数据来检查自己缓存的数据有效性，当发现自己缓存行对应的内存地址的数据被修改，
 * 就会将该缓存行设置成无效状态，当CPU读取该变量时，发现所在的缓存行被设置为无效，就会重新从内存中读取数据到缓存中。
 * @date 2017/3/15
 */
public class VolatileTest {

    static class StatusVolatile {

        // 通过boolean类型的volatile变量控制状态标识
        private volatile boolean open;

        public void setOpen(boolean open) {
            this.open = open;
        }

        public void doSomething() {
            if (open) {
                System.out.println("status is open");
            } else {
                System.out.println("status is still closed");
            }
        }
    }

    // 单例 double check方式
    static class SingletonVolatile {
        // volatile维持变量的可见性
        private volatile SingletonVolatile instance;

        public SingletonVolatile getInstance() {
            if (instance == null) {
                synchronized (SingletonVolatile.class) {
                    // 不使用volatile修饰,可能看到旧值
                    if (instance == null) {
                        instance = new SingletonVolatile();
                        return instance;
                    }
                }
            }
            return instance;
        }
    }

    // 防止重排序
    static class ReorderVolatile {
        // 如果变量instance没有volatile修饰，语句1、2、3可以随意的进行重排序执行，即指令执行过程可能是3214或1324。
        private volatile ReorderVolatile instance;
        private int a;
        private int b;
        private int c;

        public ReorderVolatile() {
            a = 1;  // 1
            b = 2;  // 2
            instance = new ReorderVolatile();  // 3
            c = a + b;  // 4
        }
    }
}
