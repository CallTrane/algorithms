import java.util.Stack;

/**
 * @className: NextGreaterElementII
 * @description: 503. 下一个更大元素 II
 * @author: Carl Tong
 * @date: 2022/4/11 20:07
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // 假装变成两倍的长度
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) stack.pop();
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
