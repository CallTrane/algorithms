/**
 * @className: MinDistance
 * @description: 72. 编辑距离
 * @author: Carl Tong
 * @date: 2022/3/9 16:16
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        // 1、状态定义 : s1[0..i] 和 s2[0..j] 的最小编辑距离
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            dp[i][0] = i;
        for (int i = 1; i <= m; i++)
            dp[0][i] = i;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                // 删除 : dp[i - 1][j]  插入 : dp[i][j - 1]  替换 : dp[i - 1][j - 1]
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        return dp[n][m];
    }
}
