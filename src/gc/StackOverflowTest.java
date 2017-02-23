package gc;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 */
public class StackOverflowTest {

    public static void main(String[] args) {
        System.out.print(add());
    }

    public static int add(){
        return add();
    }
}
