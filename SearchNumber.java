/**
 * @className: SearchNumber
 * @description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @author: carl
 * @date: 2021/9/7 0:11
 */
public class SearchNumber {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        //确定右边界
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int right = l;
        if (r >= 0 && nums[r] != target) {
            return 0;
        }
        l = 0;
        r = nums.length - 1;
        //确定左边界
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int left = r;
        return right - left - 1;
    }
}
