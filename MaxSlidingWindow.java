import java.util.LinkedList;

/**
 * @className: MaxSlidingWindow
 * @description: 239. 滑动窗口最大值
 *              剑指 Offer 59 - I. 滑动窗口的最大值
 * @author: carl
 * @date: 2021/8/21 10:21
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列解法，保证队首到队尾是单调递减的
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 先填充窗口到即将计算最值的时候
        for (int i = 0; i < k - 1; i++) {
            // 从队尾开始，比当前元素小的都不要，保证入队了也是单调的
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        // 计算最值
        for (int i = k - 1; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.removeLast();
            queue.addLast(nums[i]);
            // 当前窗口答案
            res[i - k + 1] = queue.peekFirst();
            // 如果要移除的数刚好为窗口最值，就出队
            if (nums[i - k + 1] == queue.peekFirst()) queue.pop();
        }
        return res;
    }
}
