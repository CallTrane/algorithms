import java.util.Arrays;

/**
 * @className: MinimumDeleteSum
 * @description: 712. 两个字符串的最小ASCII删除和
 * @author: Carl Tong
 * @date: 2022/3/10 13:02
 */
public class MinimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dp(memo, s1, 0, s2, 0);
    }

    public int dp(int[][] memo, String s1, int i, String s2, int j) {
        if (i == s1.length()) {
            int res = 0;
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            int res = 0;
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }
        if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) memo[i][j] = dp(memo, s1, i + 1, s2, j + 1);
        else memo[i][j] = Math.min(s1.charAt(i) + dp(memo, s1, i + 1, s2, j), s2.charAt(j) + dp(memo, s1, i, s2, j + 1));
        return memo[i][j];
    }

}
