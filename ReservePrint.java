import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 06题目：从尾到头打印链表
 */
public class ReservePrint {

    private class ListNode {
        private int val;
        ListNode next;
        private ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;

        Solution1 s1 = new Solution1();
        int[] result1 = s1.reservePrint(head);

        Solution2 s2 = new Solution2();
        int[] result2 = s2.solve(head);

        Arrays.stream(result1).forEach(System.out::print);
        System.out.println();
        Arrays.stream(result2).forEach(System.out::print);
    }

    /**
     * 解法一：递归
     */
    public class Solution1 {
        int[] res;
        int i = 0, j = 0;
        public int[] reservePrint(ListNode head) {
            solve(head);
            return res;
        }

        private void solve(ListNode head) {
            //一直遍历链表，直到没有next的时候确定长度
            if (head == null) {
                res = new int[i];
                return;
            }
            i++;
            solve(head.next);
            //上面会一直递归，直到确定长度，确定长度后，开始从后往前赋值
            res[j] = head.val;
            j++;
        }
    }


    /**
     * 解法二：借用辅助栈
     */
    public class Solution2 {
        public int[] solve(ListNode head) {
            LinkedList<Integer> stack = new LinkedList();
            while (head != null) {
                stack.addLast(head.val);
                head = head.next;
            }
            int[] res = new int[stack.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = stack.removeLast();
            }
            return res;
        }
    }
}
