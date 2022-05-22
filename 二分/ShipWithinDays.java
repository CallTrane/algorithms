package 二分;

/**
 * @className: ShipWithinDays
 * @description: 1011. 在 D 天内送达包裹的能力
 * @author: Carl Tong
 * @date: 2022/5/22 11:09
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int curDay = f(mid, weights);
            if (curDay == days)
                right = mid;
            else if (curDay < days)
                right = mid;
            else if (curDay > days)
                left = mid + 1;
        }
        return left;
    }

    // 定义 : 自变量 x 为船运载能力，返回值为需要的天数
    private int f(int x, int[] weights) {
        int ability = x, day = 1;
        for (int weight : weights) {
            if (ability < weight) {
                ability = x;
                day++;
            }
            ability -= weight;
        }
        return day;
    }
}
