/**
 * @className: ReverseBetween
 * @description: 92. 反转链表 II
 * @author: carl
 * @date: 2021/9/9 16:11
 */
public class ReverseBetween {

    class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;

        ListNode pre = dummyhead;
        ListNode current = dummyhead.next;
        int index = 1;
        while (index < left && current.next != null) {
            pre = pre.next;
            current = current.next;
            index++;
        }
        while (index < right && current != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = pre.next;
            pre.next = next;
            index++;
        }
        return dummyhead.next;
    }
}
