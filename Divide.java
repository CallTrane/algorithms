/**
 * @className: Divide
 * @description: 剑指 Offer II 001. 整数除法
 * @author: Carl Tong
 * @date: 2022/3/19 22:23
 */
public class Divide {
    public int divide(int a, int b) {
        if (a == 0) return 0;
        if (b == 1) return a;
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        // 记录负数的个数，并将两数都转为负数
        int negative = 2;
        if(a > 0) {
            negative--;
            a = -a;
        }
        if(b > 0) {
            negative--;
            b = -b;
        }
        int res = 0;
        // 两个负数的除法
        while (a <= b) {
            int value = b, count = 1;
            // 除数每次从1倍开始翻倍。直到-2^31的一半-2^30
            while (value >= 0xc0000000 && a <= (value + value)) {
                value += value;
                count += count;
            }
            a -= value;
            res += count;
        }
        return negative == 1 ? -res : res;
    }
}

class TestDivide {
    public static void main(String[] args) {
        new Divide().divide(-2147483648, 2);
    }
}