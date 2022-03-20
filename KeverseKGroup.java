/**
 * @className: KeverseKGroup
 * @description: 25. K 个一组翻转链表
 * @author: carl
 * @date: 2021/9/17 15:22
 */
public class KeverseKGroup {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            pre = reverse(pre, end);
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode pre, ListNode end) {
        ListNode current = pre.next;
        while (pre.next != end) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return current;
    }
}
