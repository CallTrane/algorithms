/**
 * @className: CuttingRope
 * @description:
 * @author: carl
 * @date: 2021/9/5 21:25
 */
public class CuttingRope {
    /**
     * 剑指 Offer 14- I. 剪绳子
     *
     * @param n
     * @return
     */
    public int cuttingRope1(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a) * 2;
        }
    }

    /**
     * 剑指 Offer 14- II. 剪绳子 II
     *
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < (i + 1) >> 1; j++) {

            }
        }
        return cache[n];
    }
}

