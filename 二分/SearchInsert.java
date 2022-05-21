package 二分;

/**
 * @className: SearchInsert
 * @description: 35. 搜索插入位置
 * @author: Carl Tong
 * @date: 2022/5/21 23:07
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        // 搜索数一般用左闭右闭（搜索区间边界用左闭右开）
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return left;
    }
}
