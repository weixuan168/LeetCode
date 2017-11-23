package LongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xuan on 2017/5/23.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        } else {
            int length=1;
            Set<Character> set = new HashSet<>();
            for(int i=0;i<s.length();i++) {
                set.clear();
                for(int j=i;j<s.length();j++) {
                    if (set.contains(s.charAt(j))) {
                        length = length < (j-i)? (j-i) : length;
                        break;
                    }
                    if (j == (s.length() - 1)) {
                        length = length < (j-i+1)? (j-i+1) : length;
                        break;
                    }
                    set.add(s.charAt(j));
                }

            }
            return length;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abc"));
    }
}
