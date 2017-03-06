package sorter;

import java.util.Comparator;

/**
 * @author Kevin
 * @description 选择排序
 * 1.在未排序序列中找到最小元素，存放到排序序列的起始位置。
 * 2.再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
 * 3.以此类推，直到所有元素均排序完毕。
 * @date 2017/3/5
 */
public class SelectSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        T temp;
        for (int i = 0, size = list.length; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (list[j].compareTo(list[k]) < 0) {
                    k = j;
                }
                temp = list[i];
                list[i] = list[k];
                list[k] = temp;
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator comp) {

    }
}
