/**
 * @className: LastRemaining
 * @description: 剑指 Offer 62. 圆圈中最后剩下的数字
 * @author: carl
 * @date: 2021/9/9 0:03
 */

//约瑟夫环问题 ： (当前index + m) % 上一轮剩余数字的个数
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        // 最后一轮，结果下标肯定是 0
        int index = 0;
        // 那么上一轮，有两个元素，此轮次中结果下标为 index = (index(上一轮的index，也就是最后一轮的0) + m) % n
        // 那么上上一轮，有三个元素，此伦次中的结果下标为 index = (index(上一轮的index) + m) % n。
        // 以此类推，到第 n 轮
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }
}
