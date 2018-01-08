package BinarySearch;

/**
 * Created by Xuan on 2018/1/8.
 * 第35题。给定一个已排序数组和一个目标值。如果目标值在数组中，返回其下标；如果不在，返回将其插入数组后所在的下标。
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo; //注意lo停留的位置就是要插入的位置
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 7};
        SearchInsertPosition search = new SearchInsertPosition();
        System.out.println(search.searchInsert(array, 3));
        System.out.println(search.searchInsert(array, 0));
        System.out.println(search.searchInsert(array, 9));
    }
}
