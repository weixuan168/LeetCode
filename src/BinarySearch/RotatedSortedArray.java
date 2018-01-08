package BinarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xuan on 2018/1/8.
 * 第33题。假定一个以升序排序的数组在某些节点处被翻转了。例如 0，1，2，3，4，5，6，7 变成了 4，5，6，7，0，1，2，3，
 * 你并不知道在哪儿翻转了。对于这样的数组，从中查找指定数值，找到返回数组下标，找不到返回-1.
 * 假定数组中不存在重复元素。
 */
public class RotatedSortedArray {

    /**
     * 思路1：散列表查找（将要查找数组按照元素为键，下标为值存到Map里）。
     * @param array
     * @param key
     * @return
     */
    public int search(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++) {
            map.put(array[i], i);
        }
        return map.getOrDefault(key, -1);
    }

    /**
     * 思路2：顺序查找
     * @param array
     * @param key
     * @return
     */
    public int search1(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        for(int i=0;i<array.length;i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 思路3：二分查找（由于存在翻转，对于二分查找的过程中，lo和hi的移动需要进行判断）
     * @param array
     * @param key
     * @return
     */
    public int search2(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] > array[hi]) { //如果中间值大于最右值，则说明左半段有序，判断target是否落在左半段内
                if (key >= array[lo] && key < array[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { //如果中间值小于最右值，则说明右半段有序，判断target是否落在右半段内
                if (key > array[mid] && key <= array[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2, 3};

        RotatedSortedArray search = new RotatedSortedArray();
        System.out.println(search.search2(array, 2));
    }
}
