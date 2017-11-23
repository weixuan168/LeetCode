package AddTwoNumbers;

/**
 * Created by Xuan on 2017/5/23.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int sum = 0;
        int n1;
        int n2;
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            n1 = (l1 == null ? 0 : l1.val);   //注意三元运算符的使用，提升代码简洁性；
            n2 = (l2 == null ? 0 : l2.val);
            sum += (n1 + n2);
            temp.next = new ListNode(sum % 10);
            sum = sum / 10;
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (sum == 1) {
            temp.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
//        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(1);
//        ListNode tem = new ListNode(9);
//        l2.next = tem;
//        for (int i = 0; i < 8; i++) {
//            tem.next = new ListNode(9);
//            tem = tem.next;
//        }
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
