/**
 * @className: MissingNumber
 * @description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @author: carl
 * @date: 2021/9/8 2:08
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
