package gc;

/**
 * @author Kevin
 * @description finalize
 * @date 2017/3/15
 * Vm Args:-verbose:gc -XX:+PrintGCDetails
 */
public class FinalizeTest {
    private static Block holder = null;

    public static void main(String[] args) throws Exception {
        holder = new Block();
//        holder = null;
        System.gc();
        System.in.read();
        System.gc();
        System.in.read();
    }

    static class Block {
        byte[] _200M = new byte[200 * 1024 * 1024];

        // 重写了finalize方法后,如果该对象已经失去引用,当gc触发时finalize方法将被调用一次,该次gc该对象不会被回收
        // 在finalize方法中可进行一些资源的释放操作,待下次gc对象被回收,finalize方法将不会被执行
        @Override
        protected void finalize() throws Throwable {
            System.out.println("invoke finalize");
        }
    }
}
