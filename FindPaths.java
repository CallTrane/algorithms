/**
 * @className: FindPaths
 * @description: 576. 出界的路径数
 * @author: Carl Tong
 * @date: 2022/2/19 16:43
 */
public class FindPaths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 1）状态定义：三个可变参数
        int[][][] dp = new int[m][n][maxMove + 1];
        // 初始化矩阵边缘数据
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 必须分开写，防止四个角少加
                    if (i == 0) dp[i][j][k]++;
                    if (i == m - 1) dp[i][j][k]++;
                    if (j == 0) dp[i][j][k]++;
                    if (j == n - 1) dp[i][j][k]++;
                }
            }
        }
        // 2）转移方程：f[(x,y)][step] = f[(x−1,y)][step−1] + f[(x+1,y)][step−1] + f[(x,y−1)][step−1] + f[(x,y+1)][step−1]
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int nx = i + dir[0], ny = j + dir[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        dp[i][j][k] += dp[nx][ny][k - 1] % (int) (1e9 + 7);
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}
