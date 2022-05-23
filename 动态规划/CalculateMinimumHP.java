package 动态规划;

/**
 * @className: CalculateMinimumHP
 * @description: 174. 地下城游戏
 * @author: Carl Tong
 * @date: 2022/5/23 13:02
 */
public class CalculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // 定义 dp[i][j] = x : 从 dungeon[i][j] 出发到终点(dungeon[m - 1][n - 1]) ，最少需要x生命值
        int[][] dp = new int[m][n];
        // base case : 到达终点最少需要1滴血存活
        dp[m - 1][n - 1] = 1 + (dungeon[m - 1][n - 1] > 0 ? 0 : -dungeon[m - 1][n - 1]);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if (i + 1 < m)
                    down = dp[i + 1][j];
                if (j + 1 < n)
                    right = dp[i][j + 1];
                dp[i][j] = Math.min(down, right) - dungeon[i][j];
                // 最少需要一滴血存活
                if (dp[i][j] <= 0) dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }
}
