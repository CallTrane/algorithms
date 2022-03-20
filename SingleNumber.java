/**
 * @className: SingleNumber
 * @description: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @author: carl
 * @date: 2021/9/8 0:18
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        int result = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result = result | (count[31-i] % m);
        }
        return result;
    }
}
