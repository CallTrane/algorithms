/**
 * @className: KnightProbability
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/2/17 16:19
 */
public class KnightProbability {
    public double knightProbability(int n, int k, int row, int column) {
        // 8种走的方式
        int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
        // dp[step][i][j] : 表示已经走了step步到了(i,j)这个位置
        double[][][] dp = new double[k + 1][n][n];
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 代表棋盘上初始每个位置走0步的概率都为1
                dp[0][i][j] = 1;
            }
        }
        for (int x = 1; x <= k; x++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int bi = i + dir[0], bj = j + dir[1];
                        // 位置不能越界
                        if (bi >= 0 && bi < n && bj >= 0 && bj < n) {
                            // 从各个方向走一步到达 (i,j) 这个位置
                            dp[x][i][j] += dp[x - 1][bi][bj] / 8;
                        }
                    }
                }
            }
        }
        // 从其他位置从 k 步到达 (row, column) 这个位置
        return dp[k][row][column];
    }
}
