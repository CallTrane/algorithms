/**
 * @className: LongestPalindrome
 * @description: 5. 最长回文子串
 * @author: carl
 * @date: 2021/8/25 23:56
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = longestPalindrome(s, i, i);
            String s2 = longestPalindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    // Manacher's Algorithm（马拉车算法）
}
