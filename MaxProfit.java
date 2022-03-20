/**
 * @className: StockMaxProfit
 * @description: 剑指 Offer 63. 股票的最大利润
 * @author: carl
 * @date: 2021/8/24 16:03
 */
public class MaxProfit {

    int profix, cost;

    public int maxProfit(int[] prices) {
        cost = Integer.MAX_VALUE;
        profix = 0;
        for (int price : prices) {
            cost = Math.min(price, cost);
            profix = Math.max(price - cost, profix);
        }
        return profix;
    }
}
