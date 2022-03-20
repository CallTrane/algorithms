/**
 * @className: SearchTreasure
 * @description: nyoj712 - 探寻宝藏(双程动态规划)
 * @author: Carl Tong
 * @date: 2022/3/6 2:22
 */
public class SearchTreasure {
    // 两人速度相同，如果某一时刻在相同的行或者列，则他们一定会在相同的列或行，因此保证他们行不相同，既可以保证列不相交
    public int searchTreasure(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 1、状态定义：dp[k][i][j]。走到第k步（在起点时是第二步），A走到i行，B走到j行时所得的最大宝藏数，则A在的列为k-i,B为k-j\
        // 本来是由四维数组的，有可能超时就换成三维的，即合并维度
        int[][][] dp = new int[m + n][m][m];
        // 总步数为 m + n - 2
        for (int k = 2; k < dp.length; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    // 如果 i == j，说明会出现相交，不能取；不能超过步数(越界)
                    if (i != j && k >= i && k >= j) {
                        // dp[k - 1][i][j]：上一步两条路是由上边走来的，所以行是不用变的
                        // dp[k - 1][i - 1][j - 1]：上一步两条路都是由左边走来的，所以行都要-1
                        // dp[k - 1][i][j - 1] ：第一条路是从上边走来的，第二条路是从左边走来的
                        // dp[k - 1][i - 1][j] ： 第一条路是从左边走来的，第二条路是从下边走来的
                        // matrix[i][k - i] + matrix[j][k - j] ：这里绝对不会出现相交，因为是两条路，所以要同时加上两个值
                        dp[k][i][j] = Math.max(Math.max(dp[k - 1][i][j], dp[k - 1][i - 1][j - 1]),
                                Math.max(dp[k - 1][i][j - 1], dp[k - 1][i - 1][j])) + matrix[i][k - i] + matrix[j][k - j];
                    }
                }
            }
        }
        // 求dp[m + n - 1][m - 1][m - 1]时，只有两种情况，AB分别从上或右方到达终点
        dp[m + n - 1][m][m] = Math.max(dp[m + n - 2][m - 2][m - 1], dp[m + n - 2][m - 1][m - 2]) + matrix[m - 1][n - 1];
        return dp[m + n - 1][m - 1][m - 1];
    }
}
