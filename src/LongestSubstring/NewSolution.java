package LongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xuan on 2017/5/26.
 */
public class NewSolution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int length = 0;
        int i = 0;
        int j = 0;
        int n = s.length();
        while (j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                length = length < (j - i) ? (j - i) : length;
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return length;
    }

    public static void main(String[] args) {
        NewSolution newSolution = new NewSolution();
        System.out.println(newSolution.lengthOfLongestSubstring("a"));
        System.out.println(newSolution.lengthOfLongestSubstring("aaa"));
        System.out.println(newSolution.lengthOfLongestSubstring("abc"));
        System.out.println(newSolution.lengthOfLongestSubstring("pwkew"));
    }
}
