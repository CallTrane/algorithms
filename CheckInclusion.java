import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @className: CheckInclusion
 * @description: 567. 字符串的排列
 * @author: Carl Tong
 * @date: 2022/3/12 11:41
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) valid++;
            }
            if (valid == need.size()) return true;
            // 收缩窗口（上面right提前右移了，这里不用+1补回来）
            while (right - left == s1.length()) {
                char l = s2.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (Objects.equals(window.get(l), need.get(l))) valid--;
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return false;
    }
}
