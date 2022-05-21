package 二分;


/**
 * @className: BinarySearch
 * @description: 二分搜索解法
 * @author: Carl Tong
 * @date: 2022/5/21 17:27
 */
public class BinarySearch {

    private static final int NOT_FOUND = -1;

    // 1、寻找一个数
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 注意：终止条件是 left > right, 此时数组所有元素遍历完毕仍没有找到
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 如果找到直接返回
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return NOT_FOUND;
    }

    // ================= 搜索左右侧边界的二分查找，常用左闭右开写法 ====================
    // 搜索区间是 [left, right) 左闭右开，所以当 nums[mid] 被检测之后，下一步应该去 mid 的左侧或者右侧区间搜索，即 [left, mid) 或 [mid + 1, right), 同时也决定了 left = mid + 1 和 right = mid

    // 2、寻找左侧边界的二分搜索 （可以理解返回值为数组中小于target的有多少个）
    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        // 注意：终止条件是 left == right
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 不要立即返回，而是缩小上界，不断向左收缩
            if (nums[mid] == target)
                right = mid;
            else if (nums[mid] > target)
                right = mid;
            else if (nums[mid] < target)
                left = mid + 1;
        }
        // 检查出界情况（此时 left == right）, target 比所有数都大
        if (left >= nums.length || nums[left] != target) return NOT_FOUND;
        return left;
    }

    // 3、寻找右侧边界的二分搜索
    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        // 注意：终止条件是 left == right
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 不要立即返回，而是收缩下界，向右收缩
            if (nums[mid] == target)
                // mid = left - 1，就是说 while 循环结束时，nums[left] 一定不等于 target 了，而是 nums[left-1] 可能是 target
                left = mid + 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        // 检查出界情况（此时 left == right）, target 比所有数都小
        if (right <= 0 || nums[right - 1] != target) return NOT_FOUND;
        return right - 1;
    }


}
