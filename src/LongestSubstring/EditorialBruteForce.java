package LongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xuan on 2017/5/24.
 */
public class EditorialBruteForce {
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<s.length()+1;j++) {
                if (allUnique(s,i,j)) {                        //注意此处区别，不需要substring
                    length = length < (j-i)? (j-i) : length;
                }
            }
        }
        return length;
    }

    public boolean allUnique(String s,int start,int end) {
        Set<Character> set = new HashSet<>();
        for(int i=start;i<end;i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        EditorialBruteForce bruteForce = new EditorialBruteForce();
        System.out.println(bruteForce.lengthOfLongestSubstring("a"));
    }
}
