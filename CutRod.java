/**
 * @className: CutRod
 * @description: CLRS 15.1钢条切割
 * @author: Carl Tong
 * @date: 2022/2/9 2:05
 */
public class CutRod {

    /**
     * 自底向上法
     *
     * @return
     */
    public int bottomUp(int[] price, int n) {
        // 保存子问题的解
        int[] profit = new int[n + 1];
        // 初始变量
        profit[0] = 0;
        // 从 1~n 按升序求子问题的解
        for (int i = 1; i <= n; i++) {
            int curProfit = Integer.MIN_VALUE;
            // 将子问题分为j, i-j求解（但规模不能超过父问题），j通过价格表直接获取，i-j通过直接访问来获取
            for (int j = 1; j <= i; j++) {
                curProfit = Math.max(curProfit, price[j] + profit[i - j]);
            }
            profit[i] = curProfit;
        }
        return profit[n];
    }
}
