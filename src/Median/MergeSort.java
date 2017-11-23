package Median;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuan on 2017/5/26.
 */
public class MergeSort {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        double median;
        int i=0,j=0;
        int s1 = nums1.length;
        int s2 = nums2.length;
        while (i < s1 && j < s2) {
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i++]);
            } else {
                list.add(nums2[j++]);
            }
        }
        if (i < s1) {
            while (i < s1) {
                list.add(nums1[i++]);
            }
        }
        if (j < s2) {
            while (j < s2) {
                list.add(nums2[j++]);
            }
        }
        int length = list.size();
        if (length % 2 == 0) {
            median = (double) (list.get(length / 2)+list.get(length/2-1))/2;
        } else {
            median = (double) list.get((length -1) / 2);
        }
        return median;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        double median = mergeSort.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});
        System.out.println(median);
    }
}
