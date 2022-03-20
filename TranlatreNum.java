/**
 * @className: TranlatreNum
 * @description: TODO
 * @author: carl
 * @date: 2021/8/26 15:35
 */
public class TranlatreNum {
    public int translateNum(int num) {
        int a = 1, b = 1;
        int left, right = num % 10;
        while (num != 0) {
            num = num / 10;
            left = num % 10;
            int tmp = left * 10 + right;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            right = left;
        }
        return a;
    }
}
