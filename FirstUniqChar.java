import java.util.HashMap;

/**
 * @className: FirstUniqChar
 * @description: TODO
 * @author: carl
 * @date: 2021/9/4 10:46
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : chars) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
