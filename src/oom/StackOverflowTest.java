package oom;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 * VM Args -Xss128k
 */
public class StackOverflowTest {

    int stackLength = 1;

    public static void main(String[] args) {
        StackOverflowTest sof = new StackOverflowTest();
        try {
            sof.add();
        } catch (Throwable e) {
            System.out.println("stack length:" + sof.stackLength);
            throw e;
        }
    }

    public int add() {
        stackLength++;
        return add();
    }
}
