package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 */
public class MemoryLeakTest {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        Runtime run = Runtime.getRuntime();

        int i = 1;

        while (true) {
            int[] arr = new int[1024];
            list.add(arr);

            if (i++ % 1000 == 0) {
                System.out.print("最大堆内存=" + run.maxMemory() / 1024 / 1024 + "M, ");
                System.out.print("已分配内存=" + run.totalMemory() / 1024 / 1024 + "M, ");
                System.out.print("剩余空间内存=" + run.freeMemory() / 1024 / 1024 + "M, ");
                System.out.println("最大可用内存=" + (run.maxMemory() - run.totalMemory() + run.freeMemory()) / 1024 / 1024 + "M");
                sleep(1000);
            }
        }
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
