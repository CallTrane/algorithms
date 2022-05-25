package 动态规划;

import java.util.Arrays;

/**
 * @className: FindCheapestPrice
 * @description: 787. K 站中转内最便宜的航班
 * @author: Carl Tong
 * @date: 2022/5/24 23:23
 */
public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // （这里要 k + 2 的原因是：最多可经过 k 次中转站，也就是最多乘坐 k + 1 次航班，加上一次 0 的base case）
        // dp[i][j] = x : 定义为到达 i 城市，乘坐了 j 次航班，最少花费为 x
        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // base case
        dp[src][0] = 0;
        // 开始遍历
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                if (dp[from][t - 1] != Integer.MAX_VALUE) dp[to][t] = Math.min(dp[to][t], dp[from][t - 1] + cost);
            }
        }
        // 遍历 1 ~ k+1 中最少花费到目的地的
        int cost = Arrays.stream(dp[dst]).min().getAsInt();
        // 如果不存在这样的路线，则返回-1
        return cost == Integer.MAX_VALUE ? -1 : cost;
    }
}
