import java.util.Arrays;

/**
 * @className: MaxSubArray
 * @description: 剑指 Offer 42. 连续子数组的最大和
 *               53. 最大子数组和
 * @author: Carl Tong
 * @date: 2022/2/17 18:53
 */
public class MaxSubArray {

    // 由于只与前一个状态有关系，可以压缩空间
    public int maxSubArray(int[] nums) {
        int pre = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }

    // 动态规划
    /*public int maxSubArray(int[] nums) {
        // 以 nums[i] 为结尾的「最大子数组和」为 dp[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE); dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int count : dp) {
            res = Math.max(res, count);
        }
        return res;
    }*/
}
