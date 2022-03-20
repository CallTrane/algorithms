/**
 * @className: ReverseWords
 * @description: 151. 翻转字符串里的单词
 * @author: Carl Tong
 * @date: 2022/2/9 18:17
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) return s;
        int right = s.length() - 1, left = right;
        StringBuilder builder = new StringBuilder();
        while (left > 0) {
            while (right > 0 && s.charAt(right) == ' ') right--;
            if (s.charAt(right) == ' ' && right == 0) break;
            left = right;
            while (left > 0 && s.charAt(left - 1) != ' ') left--;
            builder.append(s, left, right + 1);
            builder.append(" ");
            right = left - 1;
        }
        return builder.substring(0, builder.length() - 1);
    }
}
