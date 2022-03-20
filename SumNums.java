/**
 * @className: SumNums
 * @description: 剑指 Offer 64. 求1+2+…+n
 * @author: carl
 * @date: 2021/8/28 23:52
 */

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNums {

    int result;

    public int sumNums(int n) {
        boolean recur = n > 1 && sumNums(n - 1) > 0;
        result += n;
        return result;
    }
}
