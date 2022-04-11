/**
 * @className: CountNumbersWithUniqueDigits
 * @description: 357. 统计各位数字都不同的数字个数
 * @author: Carl Tong
 * @date: 2022/4/11 14:29
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        // 从每一位开始算，d个数字的答案为9 * A (d-1) 9
        int res = 10, pre = 9;
        // 从第二位开始算
        for (int i = 2, cur = 9; i <= n; i++) {
            pre = pre * cur--;
            res += pre;
        }
        return res;
    }
}
