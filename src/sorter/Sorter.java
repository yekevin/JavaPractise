package sorter;

import java.util.Comparator;

/**
 * Created by Administrator on 2017/3/5.
 */
public interface Sorter {

    /**
     * 排序
     * @param list 待排序的数组
     */
    public <T extends Comparable<T>> void sort(T[] list);

    /**
     * 排序
     * @param list 待排序数组
     * @param comp 比较器
     */
    public <T> void sort(T[]list, Comparator comp);
}
