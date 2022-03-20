/**
 * @className: CanPartition
 * @description: 416. 分割等和子集
 * @author: Carl Tong
 * @date: 2022/3/21 0:37
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        sum /= 2;
        // int[][] dp = new dp[n + 1][sum + 1];
        // dp[i][j] : 对于前 i 个物品，当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满, 否则为false
        // dp[i][j] = dp[i - 1][j] (这个不拿) || dp[i - 1][j - val[i]] (这个拿)
        // 为什么是 || , 因为取决于你要不要把这个数字当作子集，只要二者有一个满足即可
        boolean[] dp = new boolean[sum + 1]; // 只与前一个状态有关，降维
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            // 每个数字只能用一次，所以从后往前，避免前面的对后面造成影响
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
