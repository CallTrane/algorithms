import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @className: T1
 * @description: TODO
 * @author: carl
 * @date: 2021/8/26 16:23
 */
public class HuYa {
    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode trans(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode tmp = head;
        ListNode link;
        while (tmp != null) {
            link = tmp.next;
            tmp.next = newHead;
            newHead = tmp;
            tmp = link;
        }
        return newHead;
    }


    Map<Character, String> map = new HashMap();
    public void deleteChar(char c) {
        Iterator<Map.Entry<Character, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, String> entry = iterator.next();
            Character key = entry.getKey();
            String value = entry.getValue();
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == c) {
                    map.remove(key, value);
                    break;
                }
            }
        }
    }
}
