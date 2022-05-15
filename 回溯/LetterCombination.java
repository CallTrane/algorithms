package 回溯;

import java.util.*;

/**
 * @className: LetterCombination
 * @description: 17. 电话号码的字母组合
 * @author: Carl Tong
 * @date: 2022/5/15 16:11
 */
public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        Map<Integer, String[]> map = new HashMap() {
            {
                put(2, new String[]{"a", "b", "c"});
                put(3, new String[]{"d", "e", "f"});
                put(4, new String[]{"g", "h", "i"});
                put(5, new String[]{"j", "k", "l"});
                put(6, new String[]{"m", "n", "o"});
                put(7, new String[]{"p", "q", "r", "s"});
                put(8, new String[]{"t", "u", "v"});
                put(9, new String[]{"w", "x", "y", "z"});
            }
        };
        List<String> ret = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        backtrack(map, digits, 0, track, ret);
        return ret;
    }

    private void backtrack(Map<Integer, String[]> map, String digits, int start, StringBuilder track, List<String> ret) {
        if (track.length() == digits.length()) {
            ret.add(track.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            int cur = digits.charAt(i) - '0';
            for (String alphabet : map.get(cur)) {
                track.append(alphabet);
                backtrack(map, digits, i + 1, track, ret);
                track.deleteCharAt(track.length() - 1);
            }
        }
    }
}
