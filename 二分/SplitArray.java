package 二分;

/**
 * @className: SplitArray
 * @description: 410. 分割数组的最大值
 * @author: Carl Tong
 * @date: 2022/5/22 12:00
 */
public class SplitArray {
    public int splitArray(int[] nums, int m) {
        // left为nums中最大的一个元素，right为所有元素之和+1
        int left = 0, right = 1;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        // 终止条件为 left == right，表示搜索区间为[left, right)，在区间内搜索满足分为m个子数组，子数组其中一个最大的元素之和
        while (left < right) {
            // 子数组最大元素之和
            int mid = left + ((right - left) >> 1);
            // 在元素之和下，分成多少个连续子数组
            int count = f(mid, nums);
            // 寻找左边界
            if (count == m)
                right = mid;
            // 元素之和太大，导致分的子数组过少
            else if (count < m)
                right = mid;
            // 反之同理
            else if (count > m)
                left = mid + 1;

        }
        // 此时 left == right，代表满足分为m个连续子数组时，最大的子数组元素之和
        return left;
    }

    // 定义：连续子数组的元素之和，不得超过自变量x，返回在该情况下能分为多少个子数组
    private int f(int x, int[] nums) {
        int sum = x, count = 1;
        for (int num : nums) {
            if (sum < num) {
                sum = x;
                count++;
            }
            sum -= num;
        }
        return count;
    }
}
