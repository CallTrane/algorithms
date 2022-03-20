import java.util.*;

/**
 * @className: LengthOfLongestSubString
 * @description: 剑指 Offer 48. 最长不含重复字符的子字符串 3. 无重复字符的最长子串
 * @author: carl
 * @date: 2021/8/18 21:11
 */
public class LengthOfLongestSubString {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            // 窗口右移条件
            while (window.get(c) > 1) {
                char l = s.charAt(left);
                left++;
                window.put(l, window.get(l) - 1);
            }
            res = Math.max(right - left, res);
        }
        return res;
    }
}
