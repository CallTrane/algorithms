/**
 * @className: MinDistance583
 * @description: 583. 两个字符串的删除操作
 * @author: Carl Tong
 * @date: 2022/3/10 1:04
 */
public class MinDistance583 {
    // 求最长公共子序列（即是最后两个字符串的结果）
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return n + m - 2 * dp[n][m];
    }
}
