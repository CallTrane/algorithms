/**
 * @className: Fibonacci
 * @description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author: carl
 * @date: 2021/8/18 12:38
 */
public class Fibonacci_2 {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n % 1000000007;
        }
        int f1 = 1, f2 = 2;
        int sum = f1 + f2;
        for (int i = 3; i < n; i++) {
            f1 = f2;
            f2 = sum;
            sum = (f1 + f2) % 1000000007;
        }
        return sum;
    }
}
