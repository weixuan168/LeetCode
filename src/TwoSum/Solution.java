package TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xuan on 2017/5/22.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
    public static void main(String[]  args){
//        long startTime1 = System.currentTimeMillis();
        Solution solution= new Solution();
        int[] nums={3,2,4};
        int a[]=solution.twoSum(nums, 6);
        System.out.println(a[0]);
        System.out.println(a[1]);
//        long endTime1 = System.currentTimeMillis();
    }
}

