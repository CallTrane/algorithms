/**
 * @className: MaxProfitIV
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/8 20:53
 */
public class MaxProfitIV {
    public int maxProfit(int maxK, int[] prices) {
        if (prices == null || prices.length <= 0) return 0;
        int n = prices.length;
        if (maxK > n / 2) return maxProfitInf(prices);
        int[][][] dp = new int[maxK + 1][n][2];
        // k == 0
        for (int i = 0; i < n; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        // 最外层是天数，因为是随着时间推移进行交易，交易次数才可能会不断地减少
        for (int i = 0; i < n; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    dp[k][i][0] = 0;
                    dp[k][i][1] = -prices[i];
                    continue;
                }
                dp[k][i][0] = Math.max(dp[k][i - 1][0], dp[k][i - 1][1] + prices[i]);
                dp[k][i][1] = Math.max(dp[k][i - 1][1], dp[k - 1][i - 1][0] - prices[i]);
            }
        }
        return dp[maxK][n - 1][0];
    }

    public int maxProfitInf(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        dp[0] = 0; dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }
}
