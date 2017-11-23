package TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xuan on 2017/5/22.
 */
public class TwoSum {
    //最普通的顺序查找（线性查找）
    static int linearSearch(int a[], int key) {
        int n = a.length;
        for(int i=0;i<n;i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return 0;
    }


    static int hashSearch(int a[], int key) {
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(a[i], i);
        }
        return map.get(key);
    }
    public static void main(String[] args) {

        int a[] = {55, 44, 33, 66, 77, 99};
        long startTime1 = System.currentTimeMillis();
        System.out.println(linearSearch(a, 33));
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);
        long startTime2 = System.currentTimeMillis();
        System.out.println(hashSearch(a, 33));
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - startTime2);
    }
}
