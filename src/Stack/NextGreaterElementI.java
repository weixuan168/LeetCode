package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Xuan on 2017/11/24.
 * 第496题 有数组1和数组2，数组1中元素是数组2的子集。对于数组1中的每一个元素，找到它在数组2中位置右边的下一个比它大的数，并输出。
 *         如果找不到，则输出-1.
 * 假设：1.数组1和2中元素都不重复。
 *      2.数组1和2中元素个数都不大于1000.
 *
 * 思路：（Discussion里提供的）1.用栈
 *                           2.不用栈
 */
public class NextGreaterElementI {

    /**
     * 给出数组中每一个元素的下一比其大的数，没有则输出-1
     * 思路：如果栈顶元素比当前元素小，则栈顶元素的下一比其大的数即为当前元素，弹出。否则当前元素入栈。
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i : nums) {
            while(!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            //注意此处map的函数的用法：如果找不到，则指定默认值
            result[i] = map.getOrDefault(nums[i], -1);
        }
        return result;
    }

    /**
     * 按照上一个方法的思路
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i : nums2) {
            while(!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for(int i=0;i<result.length;i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    /**
     * 不用栈，直接找的思路
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        for(int i=0;i<result.length;i++) {
            result[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        //map里存数组2每一个元素的下标
        for(int i=0;i<nums2.length;i++) {
            map.put(nums2[i], i);
        }
        for(int i=0;i< nums1.length;i++) {
            //找到数组1中的元素在数组2中的位置
            int j = map.get(nums1[i]);
            for(int k=j+1;k< nums2.length;k++) {
                if (nums2[k] > nums1[i]) {
                    result[i] = nums2[k];
                    break;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] array1 = {9, 7, 3, 8, 1, 2, 6};
        int[] array2 = {9, 7, 2};
        NextGreaterElementI n1 = new NextGreaterElementI();
        int[] result1 = n1.nextGreaterElement(array1);
        int[] result2 = n1.nextGreaterElement2(array2, array1);
        for (int i : result1) {
            System.out.print(i + ",");
        }
        System.out.println();
        for (int i : result2) {
            System.out.print(i + ",");
        }
    }
}
