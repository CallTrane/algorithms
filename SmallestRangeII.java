import java.util.Arrays;

/**
 * @className: SmallestRangeII
 * @description: 910. 最小差值 II
 * @author: carl
 * @date: 2021/8/29 22:01
 */

public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int result = nums[length-1] - nums[0];
        for (int i = 0; i < length-1; i++) {
            int min = Math.min(nums[0]+k, nums[i+1]-k);
            int max = Math.max(nums[length-1]-k, nums[i]+k);
            result = Math.min(result, max-min);
        }
        return result;
    }
}
