package BinarySearch;

/**
 * Created by Xuan on 2018/1/8.
 * 第34题。给定一个按升序排列的数组（存在重复元素），对于某一目标元素，找出其在数组中的起始下标和终止下标。
 * 算法的时间复杂度要求为O(logn)。如果目标元素不存在于数组中，返回[-1，-1]。
 */
public class SearchForARange {
    /**
     * 思路：先用二分查找确定目标是否在数组中，若在，则依据此位置，分左右两段找出起始下标和终止下标。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] error = {-1, -1};
        if (nums == null || nums.length == 0) {
            return error;
        }
        int index = binarySearch(nums, target); //二分查找找出的位置
        if (index != -1) {
            int llo = 0, lhi = index - 1;          //左半段
            int rlo = index + 1, rhi = nums.length - 1;  //右半段
            while (llo <= lhi) {
                int mid = (llo + lhi) / 2;
                if (nums[mid] == target) {       //对于左半段，中值等于目标则继续向左，否则向右
                    lhi = mid - 1;
                } else {
                    llo = mid + 1;
                }
            }
            while (rlo <= rhi) {
                int mid = (rlo + rhi) / 2;
                if (nums[mid] == target) {       //对于右半段，中值等于目标则继续向右，否则向左
                    rlo = mid + 1;
                } else {
                    rhi = mid - 1;
                }
            }
            int[] result = {lhi + 1, rlo - 1};
            return result;
        }
        return error;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 5, 7, 7, 8};
        int[] array1 = {3, 5, 5, 7, 7, 7, 9};
        SearchForARange search = new SearchForARange();

        int[] result1 = search.searchRange(array, 7);
        for (int i : result1) {
            System.out.println(i);
        }
        int[] result2 = search.searchRange(array1, 7);
        for (int i : result2) {
            System.out.println(i);
        }
        int[] result3 = search.searchRange(array1, 1);
        for (int i : result3) {
            System.out.println(i);
        }
    }
}
