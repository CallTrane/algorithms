/**
 * @className: ReverseList
 * @description: 剑指 Offer 24. 反转链表
 * @author: carl
 * @date: 2021/9/9 16:02
 */
public class ReverseList {
    class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
