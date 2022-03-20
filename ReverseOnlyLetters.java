/**
 * @className: ReverseOnlyLetters
 * @description: 917. 仅仅反转字母
 * @author: Carl Tong
 * @date: 2022/2/23 1:44
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && !((chars[left] >= 'a' && chars[left] <= 'z') || (chars[left] >= 'A' && chars[left] <= 'Z'))) left++;
            while (left < right && !((chars[right] >= 'a' && chars[right] <= 'z') || (chars[right] >= 'A' && chars[right] <= 'Z'))) right--;
            reverse(chars, left, right);
            left++;
            right--;
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] s, int a, int b) {
        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
}

class Tes1T {
    public static void main(String[] args) {
        new ReverseOnlyLetters().reverseOnlyLetters("7_28]");
    }
}
