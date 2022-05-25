package 动态规划;

import java.util.Arrays;

/**
 * @className: FindSubstringInWraproundString
 * @description: 467. 环绕字符串中唯一的子字符串
 * @author: Carl Tong
 * @date: 2022/5/25 13:46
 */
public class FindSubstringInWraproundString {
    public int findSubstringInWraproundString(String p) {
        // dp[c] = i : 以字符 c 结尾的子串的最长长度为 i （有26个字母）
        int[] dp = new int[26];
        // 先处理第一个字符
        int k = 1; dp[p.charAt(0) - 'a'] = k;
        for (int i = 1; i < p.length(); i++) {
            char cur = p.charAt(i), pre = p.charAt(i - 1);
            // 判断是否连续
            if (cur - pre == 1 || cur - pre == -25) k++;
            // 不连续则重置
            else k = 1;
            int index = cur - 'a';
            // 选出最长长度的
            dp[index] = Math.max(dp[index], k);
        }
        // 返回所有字符（不重复）的子串最长长度总和
        return Arrays.stream(dp).sum();
    }
}
