/**
 * @className: ListGetKthFromEnd
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 * @author: carl
 * @date: 2021/9/16 17:36
 */
public class ListGetKthFromEnd {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode current = head;
        for (int i = 0; i < k && pre != null; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            current = current.next;
        }
        return current;
    }
}
