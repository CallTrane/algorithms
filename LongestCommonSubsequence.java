import java.util.Arrays;

/**
 * @className: LongestCommonSubsequence
 * @description: 剑指 Offer II 095. 最长公共子序列  1143. 最长公共子序列
 * @author: Carl Tong
 * @date: 2022/3/9 18:21
 */
public class LongestCommonSubsequence {
    // 自底向上 - 动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        // 1、状态定义 dp[i][j] 为 text1[0...i - 1] text2[0...j-1] 的最长公共子序列（LCS）
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 2、转移方程
                // 相等则一定会出现在LCS中，并且是由两个索引的上一次推导而来
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                // 不相等，则可能是除去本字符推导而来，可能由[i - 1][j]、[i][j - 1]、[i - 1][j - 1]（已经被包含在前两者之中）
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}

// 自顶向下带备忘录
class LongestCommonSubsequence1 {
    // 备忘录，消除重叠子问题
    int[][] memo;

    /* 主函数 */
    int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
        return dp(s1, 0, s2, 0);
    }

    // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        // 如果之前计算过，则直接返回备忘录中的答案
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 根据 s1[i] 和 s2[j] 的情况做选择
        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 必然在 lcs 中
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中
            memo[i][j] = Math.max(
                    dp(s1, i + 1, s2, j),
                    dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}