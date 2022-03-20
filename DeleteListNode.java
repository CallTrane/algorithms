/**
 * @className: DeleteListNode
 * @description: 剑指 Offer 18. 删除链表的节点
 * @author: carl
 * @date: 2021/9/5 14:47
 */
public class DeleteListNode {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null && current.val != val) {
            pre = current;
            current = current.next;
        }
        if (current != null) {
            pre.next = current.next;
        }
        return head;
    }
}
