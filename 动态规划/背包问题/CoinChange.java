package 动态规划.背包问题;

import java.util.Arrays;

/**
 * @className: CoinChange
 * @description: 322. 零钱兑换
 * @author: Carl Tong
 * @date: 2022/3/11 21:53
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max); dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
