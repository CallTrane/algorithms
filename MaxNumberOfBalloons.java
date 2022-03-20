import java.util.HashMap;
import java.util.Map;

/**
 * @className: MaxNumberOfBalloons
 * @description: 1189. “气球” 的最大数量
 * @author: Carl Tong
 * @date: 2022/2/13 1:01
 */
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        // {字母:数量}
        Map<Character, Integer> map = new HashMap(5){{
            put('b', 0);
            put('a', 0);
            put('l', 0);
            put('o', 0);
            put('n', 0);
        }};
        for (int i = 0; i < text.length(); i++) {
            if (map.containsKey(text.charAt(i))) {
                map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
            }
        }
        int ans = 0;
        while (map.get('b') >= 1 && map.get('a') >= 1 && map.get('l') >= 2 && map.get('o') >= 2 && map.get('n') >= 1) {
            map.put('b', map.get('b') - 1);
            map.put('a', map.get('a') - 1);
            map.put('l', map.get('l') - 2);
            map.put('o', map.get('o') - 2);
            map.put('n', map.get('n') - 1);
            ++ans;
        }
        return ans;
    }
}

