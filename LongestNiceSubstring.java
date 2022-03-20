/**
 * @className: LongestNiceSubstring
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/2/21 17:17
 */
public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int idx = -1, length = 0;
        // 定位子串起始位置
        for (int i = 0; i < n; i++) {
            // 用两个 int 的低 26 位分别记录大小写字母的出现情况
            int up = 0, low = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    low |= (1 << (c - 'a'));
                } else {
                    up |= (1 << (c - 'A'));
                }
                if (up == low && j - i + 1 > length) {
                    idx = i;
                    length = j - i + 1;
                }
            }
        }
        return idx == -1 ? "" : s.substring(idx, idx + length);
    }

}
