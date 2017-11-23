package LongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xuan on 2017/5/24.
 */

/**
 * 找到string的所有substrings，判断是否有重复char
 */
public class BruteForce {
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<s.length()+1;j++) {
                String str = s.substring(i, j);   //substring包头不包尾
                if (allUnique(str)) {
                    length = length < str.length() ? str.length() : length;
                }
            }
        }
        return length;
    }

    public boolean allUnique(String s) {
        Set<Character> set = new HashSet<>(); //Set对于判断集合中是否有某个值特别方便
        for(int i=0;i<s.length();i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        System.out.println(bruteForce.lengthOfLongestSubstring("a"));
    }

}
