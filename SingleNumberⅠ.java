/**
 * @className: SingleNumberⅠ
 * @description: 136. 只出现一次的数字
 * @author: carl
 * @date: 2021/10/12 0:45
 */
public class SingleNumberⅠ {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
