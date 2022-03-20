/**
 * @className: LastRemaining
 * @description: 剑指 Offer 62. 圆圈中最后剩下的数字
 * @author: carl
 * @date: 2021/9/9 0:03
 */

//约瑟夫环问题 ： (当前index + m) % 上一轮剩余数字的个数
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
