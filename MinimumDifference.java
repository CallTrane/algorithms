import java.util.Arrays;

/**
 * @className: MinimumDifference
 * @description: 1984. 学生分数的最小差值
 * @author: Carl Tong
 * @date: 2022/2/11 13:07
 */
public class MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 0 || k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            minimum = Math.min(minimum, nums[i + k - 1] - nums[i]);
        }
        return minimum;
    }
}
