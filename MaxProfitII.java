/**
 * @className: MaxProfitII
 * @description: TODO
 * @author: carl
 * @date: 2021/8/30 13:27
 */
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i-1];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }

}
