/**
 * @className: CoinChangeII
 * @description: 518. 零钱兑换 II
 * @author: Carl Tong
 * @date: 2022/3/11 22:07
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        // dp[i] : 凑出金额i的方案数
        int[] dp = new int[amount + 1];
        // base case : 什么都不做凑出金额0，也是一种方法
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // 转移方程：不拿当前这个硬币 + 拿当前这个硬币
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}
