/**
 * @className: MinSubArrayLen
 * @description: 209. 长度最小的子数组
 * @author: Carl Tong
 * @date: 2022/2/16 15:29
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口求解
        int res = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            // 不停地把左端向右滑动
            while (sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
