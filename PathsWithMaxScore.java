import java.util.ArrayList;
import java.util.List;

/**
 * @className: PathsWithMaxScore
 * @description: 1301. 最大得分的路径数目
 * @author: Carl Tong
 * @date: 2022/2/20 19:46
 */
public class PathsWithMaxScore {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        // 转换为字符数组，便于判断坐标(x, y)
        char[][] cs = new char[n][n];
        // 两个坐标作为变的维度，返回值的分数作为存储
        int[][] dp = new int[n][n];
        // 两个坐标作为变的维度，返回值的方案数作为存储
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            cs[i] = board.get(i).toCharArray();
        }
        // 从右下角到左上角
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 初始化起点
                if (i == n - 1 && j == n - 1) {
                    g[i][j] = 1;
                    continue;
                }
                // 如果是障碍物
                if (cs[i][j] == 'X') {
                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }
                // 如果是左上角终点，则得分为0；否则为对应位置的分数
                int score = (i == 0 && j == 0) ? 0 : cs[i][j] - '0';
                // 转移方程：f[(x,y)] = max(f[(x+1,y)], f[(x,y+1)], f[(x+1,y+1)]) + board[(x,y)]
                // 从右方、下方、右下方，定位当前位置的最大分数
                int maxScore = Integer.MIN_VALUE, maxCount = 0;
                // 从下方来的如果合法
                if (i + 1 < n) {
                    int curScore = dp[i + 1][j] + score;
                    int curCount = g[i + 1][j];
                    int[] res = update(curScore, curCount, maxScore, maxCount);
                    maxScore = res[0];
                    maxCount = res[1];
                }
                // 从右方来的如果合法
                if (j + 1 < n) {
                    int curScore = dp[i][j + 1] + score;
                    int curCount = g[i][j + 1];
                    int[] res = update(curScore, curCount, maxScore, maxCount);
                    maxScore = res[0];
                    maxCount = res[1];
                }
                // 从右下方来的如果合法
                if (j + 1 < n && i + 1 < n) {
                    int curScore = dp[i + 1][j + 1] + score;
                    int curCount = g[i + 1][j + 1];
                    int[] res = update(curScore, curCount, maxScore, maxCount);
                    maxScore = res[0];
                    maxCount = res[1];
                }
                // 更新
                dp[i][j] = maxScore < Integer.MIN_VALUE ? 0 : maxScore;
                g[i][j] = maxCount;
            }
        }
        // 如果重点不可达，则返回{0, 0}
        return (dp[0][0] == Integer.MIN_VALUE || g[0][0] == 0) ? new int[]{0, 0} : new int[]{dp[0][0], g[0][0]};
    }

    private int[] update(int cur, int cnt, int u, int t) {
        // 起始答案为 [u, t] : u 为「最大得分」，t 为最大得分的「方案数」
        int[] ans = new int[]{u, t};

        // 如果当前值大于 u，更新「最大得分」和「方案数」
        if (cur > u) {
            ans[0] = cur;
            ans[1] = cnt;

            // 如果当前值等于 u，增加「方案数」
        } else if (cur == u && cur != Integer.MIN_VALUE) {
            ans[1] += cnt;
        }

        ans[1] %= 1e9 + 7;
        return ans;
    }
}
