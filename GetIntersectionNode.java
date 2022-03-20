/**
 * @className: IetIntersectionNode
 * @description: 160. 相交链表
 * @author: carl
 * @date: 2021/9/6 20:12
 */
public class GetIntersectionNode {
    class ListNode {
        int val;
        ListNode next;
        public ListNode() {

        }
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            if (A != null) {
                A = A.next;
            } else {
                A = headB;
            }
            if (B != null) {
                B = B.next;
            } else {
                B = headA;
            }
        }
        return A;
    }
}
