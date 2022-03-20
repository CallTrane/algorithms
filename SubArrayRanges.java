/**
 * @className: SubArrayRanges
 * @description: 2104. 子数组范围和
 * @author: Carl Tong
 * @date: 2022/3/4 12:27
 */
public class SubArrayRanges {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int maximum = nums[i], minimum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                maximum = Math.max(maximum, nums[j]);
                minimum = Math.min(minimum, nums[j]);
                res += maximum - minimum;
            }
        }
        return res;
    }
}
