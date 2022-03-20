/**
 * @className: ReverseString
 * @description: 344. 反转字符串
 * @author: Carl Tong
 * @date: 2022/3/17 21:43
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++; right--;
        }
    }

    private void swap(char[] chars, int a, int b) {

    }
}
