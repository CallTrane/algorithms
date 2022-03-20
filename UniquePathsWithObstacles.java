/**
 * @className: UniquePathsWithObstacles
 * @description: 63. 不同路径 II
 * @author: Carl Tong
 * @date: 2022/2/21 17:55
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        // 1、状态定义：两个坐标变量，存储返回值
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                // 2、转移方程：dp[m][n] = dp[m-1][n] + dp[m][n-1]
                if (i - 1 >= 0) dp[i][j] += dp[i - 1][j];
                if (j - 1 >= 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
