/**
 * @className: MaximumDifference
 * @description: 2016. 增量元素之间的最大差值
 * @author: Carl Tong
 * @date: 2022/2/26 2:59
 */
public class MaximumDifference {
    public int maximumDifference(int[] nums) {
        int minimum = nums[0], res = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minimum) res = Math.max(res, nums[i] - minimum);
            minimum = Math.min(minimum, nums[i]);
        }
        return res;
    }
}
