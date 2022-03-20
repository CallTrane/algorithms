import java.util.Arrays;

/**
 * @className: MergeSort
 * @description: 归并排序
 * @author: Carl Tong
 * @date: 2022/3/18 1:18
 */
public class MergeSort {

    static int[] temp;

    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        // 单个元素时不用排序
        if (right <= left) return;
        // 防止溢出
        int mid = left + (right - left) / 2;
        // 排序左半部分数组
        sort(nums, left, mid);
        // 排序后半部分数组
        sort(nums, mid + 1, right);
        // 将两个子数组合并
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        // 辅助数组
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        // 利用双指针排序
        int leftIndex = left, rightIndex = mid + 1;
        for (int i = left; i <= right; i++) {
            // 左半部分数组排序完毕
            if (leftIndex == mid + 1) nums[i] = temp[rightIndex++];
            // 右半部分数组排序完毕
            else if (rightIndex == right + 1) nums[i] = temp[leftIndex++];
            // 正常比较
            else if (temp[leftIndex] > temp[rightIndex]) nums[i] = temp[rightIndex++];
            else nums[i] = temp[leftIndex++];
        }
    }
}
