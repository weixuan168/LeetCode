package BinarySearch;

/**
 * Created by Xuan on 2018/1/8.
 * 第69题。实现int sqrt(int x)，即返回x的平方根。x默认正整数，平方根为小数的返回整数部分。
 */
public class Sqrt {

    /**
     * 第一版通过
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if (x == 1) {
            return 1;
        }
        int lo = 0, hi = x;
        while (lo < (hi - 1)) {
            int mid = (lo + hi) / 2;
            if ((x / mid) == mid) { //注意：写mid*mid会导致溢出
                return mid;
            }
            if ((x/mid)>mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 对第一版改进：考虑到完全平方数非常少，取消相等的判断。
     * 另外，乘法运算比除法运算快很多。也可以先将mid转成long型，计算mid*mid。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int lo = 0, hi = x;
        while (lo < (hi - 1)) {
            int mid = (lo + hi) / 2;
            if ((x/mid)>=mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(Integer.MAX_VALUE);//2147483647

        System.out.println(sqrt.mySqrt(1));
        System.out.println(sqrt.mySqrt(8));
        System.out.println(sqrt.mySqrt(4));
        System.out.println(sqrt.mySqrt(100));
        System.out.println(sqrt.mySqrt(2147395599));

    }
}
