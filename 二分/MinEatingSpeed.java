package 二分;


import java.util.Arrays;

/**
 * @className: MinEatingSpeed
 * @description: 875. 爱吃香蕉的珂珂
 * @author: Carl Tong
 * @date: 2022/5/22 9:12
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt() + 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (f(mid, piles) == h)
                // 搜索左侧边界
                right = mid;
            // 如果需要的时间太少，则需要减少速度x，让f(x)的返回值大一些
            else if (f(mid, piles) < h)
                right = mid;
            // 如果需要的时间太多，则需要提高速度x，让f(x)的返回值小一些
            else if (f(mid, piles) > h)
                left = mid + 1;
        }
        return left;
    }

    // 定义为若吃香蕉的速度为 x 根/小时，则需要 f(x) 小时吃完所有香蕉
    private int f(int x, int[] piles) {
        int hour = 0;
        for (int pile : piles) {
            hour += pile / x;
            if (pile % x != 0) hour++;
        }
        return hour;
    }
}
