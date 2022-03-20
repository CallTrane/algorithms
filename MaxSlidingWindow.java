import java.util.Deque;
import java.util.LinkedList;

/**
 * @className: MaxSlidingWindow
 * @description: 剑指 Offer 59 - I. 滑动窗口的最大值
 * @author: carl
 * @date: 2021/8/21 10:21
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList();
        int[] result = new int[nums.length - k + 1];
        // 当 i < k ，说明还没有形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        // 形成窗口
        result[0] = deque.peekFirst();
        // 开始滑动窗口
        for (int i = k; i < nums.length; i++) {
            // 若 i > 0 且 队首元素 deque[0] == 被删除元素 nums[i - 1] ：则队首元素出队；
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            // 删除 deque 内所有 < nums[j] 的元素，以保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
}
