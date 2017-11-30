package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Xuan on 2017/11/24.
 * 第503题 给定一个循环数组，给出其中每一个元素的下一个比其大的数，没有则输出-1
 */
public class NextGreaterElementII {

    /**
     * 暴力解 时间复杂度为O(n^2)
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for(int i=0;i<length;i++) {
            result[i] = -1;
        }
        for (int i = 0; i < length; i++) {
            for(int j=i+1;j<length+i;j++) {
                if (nums[j % length] > nums[i]) {
                    result[i] = nums[j % length];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 使用栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[i] > Integer.valueOf(stack.peek().split(",")[1])) {
                String[] s = stack.pop().split(",");
                map.put(Integer.valueOf(s[0]), nums[i]);
            }
            stack.push(i + "," + nums[i]);
        }

        for(int i=0;i<length;i++) {
            while (!stack.isEmpty() && nums[i] > Integer.valueOf(stack.peek().split(",")[1])) {
                String[] s = stack.pop().split(",");
                map.put(Integer.valueOf(s[0]), nums[i]);
            }
            if (stack.isEmpty()) {
                break;
            }
        }
        for(int i=0;i<length;i++) {
            result[i] = map.getOrDefault(i, -1);
        }
        return result;
    }

    /**
     * 使用栈优化
     * 优化一：栈中存放数组的下标，不需要存放数组的元素（222ms——69ms）
     * 优化二：不需要使用Map（69ms——44ms）
     * @param nums
     * @return
     */
    public int[] nextGreaterElements3(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for(int i=0;i<length;i++) {
            result[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        for(int i=0;i<length;i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i];
            }
            if (stack.isEmpty()) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementII n2 = new NextGreaterElementII();
        int[] a1 = {1, 2, 1};
        int[] r1 = n2.nextGreaterElements3(a1);
        for (int i : r1) {
            System.out.println(i);
        }
    }
    /**
     * NextGreaterElementI和NextGreaterElementI比较与反思：
     * 1. I中需要从父数组中找子数组中元素的下一较大元素，即同一元素，在父数组中的下标和子数组中的下标是不同的，
     *    所以需要一个以元素值作为key的map，来作为中间桥梁。
     *    而II中是找数组本身每一个元素的下一较大元素，找到的原数组的下标直接对应结果数组的下标，所以不需要中间桥梁。
     *
     * 2. I所要实现的目的本身要求了父数组不能有重复元素，所以在进出栈、存map时只考虑元素值就可以。
     *    而II中数组元素可以存在重复，所以在栈中存放的是数组的下标。
     */
}
