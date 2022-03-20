/**
 * @className: cider
 * @description: TODO
 * @author: carl
 * @date: 2021/9/6 17:20
 */
public class Cider {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode turnRound(ListNode head, int start, int end) {
        if (head == null) {
            return null;
        }
        int index = 1;
        ListNode turnStart = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (index < start && turnStart != null) {
            pre = turnStart;
            turnStart = turnStart.next;
            index++;
        }

        ListNode next = null;
        ListNode temp = turnStart;
        ListNode current = temp.next;

        while (index < end && current != null) {

            next = current.next;

            current.next = temp;
            temp = current;
            current = next;
            index++;
        }

        pre.next = temp;
        turnStart.next = next;
        return head;
    }

    /*class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }
    }

    public ListNode hashGetTrue(ListNode l1, ListNode l2) {
        ListNode newl1 = l1, newl2 = l2;
        while (newl1 != newl2) {

            if (newl1 != null) {
                newl1 = l1.next;
            } else {
                newl1 = l2;
            }

            if (newl2 != null) {
                newl2 = l2.next;
            } else {
                newl2 = l1;
            }
        }
        return newl1;
    }*/


}
