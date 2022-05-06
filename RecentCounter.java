import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: RecentCounter
 * @description: 933. 最近的请求次数
 * @author: Carl Tong
 * @date: 2022/5/6 23:38
 */
public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) queue.poll();
        queue.offer(t);
        return queue.size();
    }
}
