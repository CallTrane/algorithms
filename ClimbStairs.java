/**
 * @className: ClimbStairs
 * @description: 70. 爬楼梯
 * @author: Carl Tong
 * @date: 2022/2/28 18:36
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 1; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
