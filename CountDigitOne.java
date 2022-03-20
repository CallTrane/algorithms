/**
 * @className: CountDigitOne
 * @description: 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * @author: carl
 * @date: 2021/8/28 1:34
 */
public class CountDigitOne {
    public int countDigitOne(int n) {
        int digit = 1, result = 0;
        int high = n / 10, current = n % 10, low = 0;
        while (high != 0 || current != 0) {
            if (current == 0) {
                result += high * digit;
            } else if (current == 1) {
                result += high * digit + low + 1;
            } else {
                result += (high+1) * digit;
            }
            low += current * digit;
            current = high % 10;
            high /= 10;
            digit *= 10;
        }
        return result;
    }
}
