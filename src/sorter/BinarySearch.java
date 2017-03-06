package sorter;

import java.util.Comparator;

/**
 * @author Kevin
 * @description 折半查找，也称二分查找、二分搜索，是一种在有序数组中查找某一特定元素的搜索算法。 时间复杂度是O(logN)
 * @date 2017/3/5
 */
public class BinarySearch {

    // 使用递归实现的二分查找
    public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
        return binarySearch(x, 0, x.length - 1, key);
    }

    private static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key.compareTo(x[mid]) == 0) {
                return mid;
            } else if (key.compareTo(x[mid]) < 0) {
                return binarySearch(x, low, mid - 1, key);
            } else {
                return binarySearch(x, mid + 1, high, key);
            }
        }
        return -1;
    }

    // 使用循环实现二分查找
    public static <T> int binarySeatch(T[] x, T key, Comparator<T> comp) {
        int low = 0;
        int high = x.length - 1;
        while (low <= high) {
            // >>>是逻辑右移，是不带符号位的右移
            int mid = (low + high) >>> 1;
            int cmp = comp.compare(x[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
