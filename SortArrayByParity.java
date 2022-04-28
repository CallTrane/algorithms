/**
 * @className: SortArrayByParity
 * @description: 905. 按奇偶排序数组
 * @author: Carl Tong
 * @date: 2022/4/28 10:06
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0) {
                left++;
                continue;
            }
            swap(nums, left, right);
            right--;
        }
        return nums;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
