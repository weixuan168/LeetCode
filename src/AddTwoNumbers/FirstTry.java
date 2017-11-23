package AddTwoNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuan on 2017/5/23.
 */

/**
 * 将两个加数list全部转换为int，做完加法后，再将和转为list
 * 缺陷：基本数据类型是有长度限制的，最大的long型也不能通过leetcode的所有测试用例。
 */
public class FirstTry {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1;
        int n2;
        long num1=0L;
        long num2=0L;
        int count1=0;
        int count2=0;
        while (l1!= null) {
            n1= l1.val;
            l1 = l1.next;
            num1 += n1 * Math.pow(10, count1);
            count1++;
        }

        while (l2 != null) {
            n2 = l2.val;
            l2 = l2.next;
            num2 += n2 * Math.pow(10, count2);
            count2++;
        }

        long result = num1 + num2;
        List<ListNode> nodes = new ArrayList<>();
        int a=(int) (result%10);
        long b=(result-a)/10;
        nodes.add(new ListNode(a));
        while (b != 0) {
            a = (int) (b% 10);
            nodes.add(new ListNode(a));
            b=(b-a)/10;
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return nodes.get(0);
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l1 = new ListNode(9);

//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode tem = new ListNode(9);
        l2.next = tem;
        for(int i=0;i<8;i++) {
            tem.next = new ListNode(9);
            tem = tem.next;
        }
        FirstTry firstTry = new FirstTry();
        ListNode result= firstTry.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
