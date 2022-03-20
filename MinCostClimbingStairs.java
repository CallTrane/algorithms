/**
 * @className: MinCostClimbingStairs
 * @description: 剑指 Offer II 088. 爬楼梯的最少成本
 * @author: Carl Tong
 * @date: 2022/2/28 18:44
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            int c = Math.min(a + cost[i - 1], b + cost[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
