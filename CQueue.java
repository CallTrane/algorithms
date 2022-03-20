import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 09：用两个栈实现队列
 */
public class CQueue {

    private Deque<Integer> stack1,stack2;

    public CQueue() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

    @Test
    public void test() {
        CQueue cq = new CQueue();
        cq.appendTail(1);
        cq.appendTail(2);
        System.out.println(cq.deleteHead());
    }
}
