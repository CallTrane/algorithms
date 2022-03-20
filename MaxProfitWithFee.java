/**
 * @className: MaxProfitWithFee
 * @description: 714. 买卖股票的最佳时机含手续费
 * @author: Carl Tong
 * @date: 2022/3/7 13:45
 */
public class MaxProfitWithFee {
    /**
     * 空间优化版 : 转移的时候，dp[i] 只会从 dp[i-1] 转移得来，因此第一维可以去掉
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = 0; dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }

    /*public int maxProfit(int[] prices, int fee) {
        // 1、状态定义 : 两个变量（有没有股票、第几天）
        int[][] dp = new int[2][prices.length];
        // 初始值
        dp[0][0] = 0; dp[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 2、转移方程
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i] - fee);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
        }
        return dp[0][prices.length - 1];
    }*/

}
