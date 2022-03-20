import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @className: MinWindow
 * @description: 76. 最小覆盖子串
 * @author: Carl Tong
 * @date: 2022/3/12 0:24
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        // 记录需要的字符 (need只用来验证，过程中不操作)
        Map<Character, Integer> need = new HashMap<>(), windows = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 需要滑动窗口的双指针，验证是否条件（valid代表字符个数）
        int left = 0, right = 0, valid = 0;
        // 截取字符串的索引
        int start = 0, length = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 如果是需要的字符
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (Objects.equals(windows.get(c), need.get(c))) valid++;
            }
            // 如果满足收缩条件
            while (left < right && valid == need.size()) {
                // 更新答案
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                char l = s.charAt(left);
                left++;
                // 如果是需要的字符，判断窗口内字符数量还是否满足
                if (need.containsKey(l)) {
                    // 减少之前先判断还是否满足条件
                    if (Objects.equals(windows.get(l), need.get(l))) valid--;
                    windows.put(l, windows.get(l) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
