/**
 * @className: CopyRandomList
 * @description: TODO
 * @author: carl
 * @date: 2021/9/4 14:17
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //1、哈希表（时间复杂度 O(N)、空间复杂度 O(N) ）
    /*public Node copyRandomList1(Node head) {

    }*/

    //2、拼接 + 拆分（时间复杂度 O(N)、空间复杂度 O(1) ）
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node tmp = new Node(current.val);
            tmp.next = current.next;
            current.next = tmp;
            current = current.next.next;
        }
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        current = head.next;
        Node newHead = head.next;
        //单独处理原先链表
        Node pre = head;
        while (current.next != null) {
            //处理原链表
            pre.next = pre.next.next;
            pre = pre.next;
            //处理复制链表
            current.next = current.next.next;
            current = current.next;
        }
        pre.next = null;
        return newHead;
    }
}
