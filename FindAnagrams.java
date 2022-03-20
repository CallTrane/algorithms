import java.util.*;

/**
 * @className: FindAnagrams
 * @description: 438. 找到字符串中所有字母异位词
 * @author: Carl Tong
 * @date: 2022/3/12 15:14
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>(), need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) valid++;
            }
            // 窗口移动
            while (right - left == p.length()) {
                if (valid == need.size()) res.add(left);
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (Objects.equals(window.get(l), need.get(l))) valid--;
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return res;
    }
}
