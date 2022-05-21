package 二分;

/**
 * @className: SearchRange
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author: Carl Tong
 * @date: 2022/5/21 22:31
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0)
            return new int[]{-1, -1};
        int start = leftBound(nums, target), end = rightBound(nums, target);
        return new int[]{start, end};
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                right = mid;
            else if (nums[mid] > target)
                right = mid;
            else if (nums[mid] < target)
                left = mid + 1;
        }
        // 1、如果 target 比数组所有元素都大，会出界；2、如果找不到元素
        if (left == nums.length || nums[left] != target) return -1;
        return left;
    }

    private int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                // 即 mid = left - 1，就是说 while 循环结束时，nums[left] 一定不等于 target 了，而是 nums[left-1] 可能是 target
                left = mid + 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        // 1、如果target比所有元素都小；2、如果找不到元素
        if (right <= 0 || nums[right - 1] != target) return -1;
        // 如果找到值，应该返回 left(right) - 1，因为当我们找到target时，我们对left的更新是 left = mid + 1
        return right - 1;
    }
}
