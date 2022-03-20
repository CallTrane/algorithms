import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: MaxQueue
 * @description: TODO
 * @author: carl
 * @date: 2021/8/29 11:20
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList();
        deque = new LinkedList();
    }

    public int max_value() {
        if (deque == null || deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (!queue.isEmpty()) {
            if (queue.peek().equals(deque.peekFirst())) {
                deque.pollFirst();
            }
            return queue.poll();
        }
        return -1;
    }
}
