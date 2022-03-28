/**
 * @className: MinSubArrayLen
 * @description: 209. 长度最小的子数组
 *               剑指 Offer II 008. 和大于等于 target 的最短子数组
 * @author: Carl Tong
 * @date: 2022/2/16 15:29
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, res = Integer.MAX_VALUE, sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target && start <= end) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
