import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: Jimi
 * @description: TODO
 * @author: carl
 * @date: 2021/9/11 19:49
 */
public class Jimi {

    class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public int[] decode (int first, int[] encoded) {
        if (encoded == null || encoded.length <= 0) {
            return new int[]{first};
        }

        int[] origin = new int[encoded.length+1];
        origin[0] = first;

        //65535
        for (int i = 1; i < origin.length; i++) {
            origin[i] = origin[i-1] ^ encoded[i-1];
        }
        return origin;
    }

}
