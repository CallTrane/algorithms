/**
 * @className: MyPow
 * @description: 剑指 Offer 16. 数值的整数次方
 * @author: carl
 * @date: 2021/9/11 1:19
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double result = 1.0;
        if (b < 0) {
            x = 1 / x ;
            b = -b;
        }
        while (b > 0) {
            if (b % 2 == 1) {
                result *= x;
            }
            x *= x;
            b >>= 1;
        }
        return result;
    }
}
