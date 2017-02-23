package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 */
public class OutOfMemoryTest {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        sleep(8000);
        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {

    }

    static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
