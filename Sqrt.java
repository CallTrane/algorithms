import org.junit.Test;

/**
 * @className: Sqrt
 * @description: TODO
 * @author: trane
 * @date: 2021/7/29 16:12
 */
public class Sqrt {

    public static int a;


    // 方法一：二分查找
    /*public int sqrt(int x) {
        //特殊值
        if (x == 0|| x == 1) {
            return x;
        }
        int left = 1,right = x/2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            //如果平方大于X，则返回右区间前一个值
            if (mid > x/mid) {
                right = mid - 1;
            //否则就正常返回
            } else {
                left = mid;
            }
        }
        return left;
    }*/

    /**
     * 方法二：牛顿迭代法
     */
    public double sqrt(double x) {

        a = (int) x;

        if (x == 0) {
            return 0;
        }

        double res = (x + a/x) / 2;
        if (res == x) {
            return x;
        }
        return sqrt(res);
    }
}
