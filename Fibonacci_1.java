/**
 * @className: Fibonacci
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * @author: carl
 * @date: 2021/8/18 12:38
 */
public class Fibonacci_1 {
    public int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int f0 = 0, f1 = 1;
        int sum = f0 + f1;
        for (int i = 2; i < n; i++) {
            f0 = f1;
            f1 = sum;
            sum = (f0 + f1) % 1000000007;
        }
        return sum;
    }
}
