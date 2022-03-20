/**
 * @className: MaxProfitWithFrozen
 * @description: 309. 最佳买卖股票时机含冷冻期
 * @author: Carl Tong
 * @date: 2022/3/9 0:49
 */
public class MaxProfitWithFrozen {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n <= 0) return 0;
        // buy表示持有，sell表示未持有（售出），pre用于前两天
        int buy = Integer.MIN_VALUE, sell = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sell;
            // 要么就是前一天持有；要么就是前两天卖完，今天刚买
            buy = Math.max(buy, pre - prices[i]);
            sell = Math.max(sell, buy + prices[i]);
            pre = tmp;
        }
        return sell;
    }

    /*public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n <= 0) return 0;
        int[] dp = new int[2];
        dp[0] = 0; dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[0] = Math.max(dp[0], dp[1] + prices[i]);
                dp[1] = Math.max(dp[1], -prices[1]);
                continue;
            }
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }*/
}
