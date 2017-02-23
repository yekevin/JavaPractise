package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 */
public class StaticOverflowTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true ){
            list.add(String. valueOf(i++).intern());
        }
    }
}
