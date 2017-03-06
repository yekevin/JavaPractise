package sorter;

import java.util.Comparator;

/**
 * @author Kevin
 * @description 快速排序
 * 1.从数列中挑出一个元素，称为“基准”
 * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，
 * 所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分割之后，该基准是它的最后位置。这个称为分割（partition）操作。
 * 3.递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * @date 2017/3/5
 */
public class QuickSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        sort(list, 0, list.length);
    }

    private <T extends Comparable<T>> void sort(T[] list, int start, int end) {
        if (start < end) {
            T base = list[start]; // 选定基准值
            T temp;
            int i = start, j = end;
            do {
                while (list[i].compareTo(base) < 0 && (i < end)) {
                    i++;
                }
                while (list[j].compareTo(base) > 0 && (j > start)) {
                    j--;
                }
                if (i <= j) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                sort(list, start, j);
            }
            if (end > i) {
                sort(list, i, end);
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator comp) {

    }
}
