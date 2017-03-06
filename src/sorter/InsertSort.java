package sorter;

import java.util.Comparator;

/**
 * @author Kevin
 * @description 插入排序
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置中
 * 6.重复步骤2
 * @date 2017/3/5
 */
public class InsertSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        T temp;
        int j;
        for (int i = 1, size = list.length; i < size; i++) {
            temp = list[i];
            for (j = i; j > 0 && temp.compareTo(list[j - 1]) < 0; j--) {
                list[j] = list[j - 1];
            }
            list[j] = temp;
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator comp) {

    }
}
