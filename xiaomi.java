import java.rmi.NoSuchObjectException;
import java.util.*;

/**
 * @className: xiaomi
 * @description: TODO
 * @author: carl
 * @date: 2021/9/1 19:24
 */
public class xiaomi {

    class A implements Runnable {

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        ArrayList list;
        /*list.sort();*/
    }

    /*static class ListNode {
        int val;
        ListNode next;
        ListNode pre;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(1);
        ListNode current = head;
        head.next = current;
        current.pre = head;
        for (int i = 2; i <= n; i++) {
            ListNode tmp = new ListNode(i);
            current.next = tmp;
            tmp.pre = current;
            current = tmp;
        }

        System.out.println(remove(head, n));
    }

    static int remove(ListNode head, int n) {

        ListNode tmp = head;
        int count = 0;

        while (n != 1) {
            if (count == 3) {
                tmp.next.pre = tmp.pre;
                tmp.pre.next = tmp.next;
                count = 0;
                n--;
            }
            if (tmp.next == null) {
                tmp = head;
                count = 3;
                continue;
            }
            count++;
        }
    }*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mnStr = sc.nextLine();
        String[] tmp = mnStr.split(",");
        int m = Integer.valueOf(tmp[0].charAt(2)-'0');
        int n = Integer.valueOf(tmp[1].charAt(2)-'0');
        int[] A = new int[0], B = new int[0];

        if (m > 0 || n > 0) {
            A = new int[m+n];
        }
        if (n > 0) {
             B = new int[n];
        }

        String numB = sc.nextLine();
        tmp = numB.split(",");
        for (int i = 0; i < tmp.length; i++) {
            B[i] = Integer.valueOf(tmp[i]);
        }
        String numA = sc.nextLine();
        tmp = numA.split(",");
        for (int i = 0; i < tmp.length; i++) {
            A[i] = Integer.valueOf(tmp[i]);
        }

        int indexA = m-1, indexB = n-1, index = m+n-1;
        while (indexA >= 0 && indexB >= 0) {
            A[index--] = A[indexA] > B[indexB] ? A[indexA--] : B[indexB--];
        }
        System.arraycopy(B, 0, A, 0, indexB+1);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }*/
}
