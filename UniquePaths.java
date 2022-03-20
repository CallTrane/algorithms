/**
 * @className: UniquePaths
 * @description: 62. 不同路径
 * @author: Carl Tong
 * @date: 2022/2/21 17:26
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // 1、状态定义：两个变量
        int[][] dp = new int[m][n];
        // 初始值
        dp[0][0] = 1;
        // 开始遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 2、转移方程：dp[m][n] = dp[m-1][n] + dp[m][n-1]
                if (i - 1 >= 0) dp[i][j] += dp[i - 1][j];
                if (j - 1 >= 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
