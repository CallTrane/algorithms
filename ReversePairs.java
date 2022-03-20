/**
 * @className: ReversePairs
 * @description: 493. 翻转对
 * @author: Carl Tong
 * @date: 2022/3/19 1:35
 */
public class ReversePairs {

    private static int[] tmp;

    private int count = 0;

    public int reversePairs(int[] nums) {
        sort(nums);
        return count;
    }

    private void sort(int[] nums) {
        tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // 保存到临时数组
        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        // 先计算count
        // 进行效率优化，维护左闭右开区间 [mid+1, end) 中的元素乘 2 小于 nums[i]（为什么 end 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是一个空区间）
        int end = mid + 1;
        // 当 nums[lo..mid] 和 nums[mid+1..hi] 两个子数组完成排序后，对于 nums[lo..mid] 中的每个元素 nums[i]，去 nums[mid+1..hi] 中寻找符合条件的 nums[j]
        for (int i = left; i <= mid; i++) {
            // nums 中的元素可能较大，乘 2 可能溢出，所以转化成 long
            while (end <= right && (long) nums[i] > (long) nums[end] * 2) end++;
            count += end - (mid + 1);
        }
        // 再排序
        int leftIndex = left, rightIndex = mid + 1;
        for (int i = left; i <= right; i++) {
            if (leftIndex == mid + 1) nums[i] = tmp[rightIndex++];
            else if (rightIndex == right + 1) nums[i] = tmp[leftIndex++];
            else if (tmp[leftIndex] > tmp[rightIndex]) nums[i] = tmp[rightIndex++];
            else nums[i] = tmp[leftIndex++];
        }
    }

}
