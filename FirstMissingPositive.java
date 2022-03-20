/**
 * @className: FirstMissingPositive
 * @description: 41. 缺失的第一个正数
 * @author: Carl Tong
 * @date: 2022/3/4 20:49
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            // 这里需要不停交换
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return  nums.length + 1;
    }

    private void swap(int[] arr, int a, int b ) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}

class TFirstMissingPositive {
    public static void main(String[] args) {
        new FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1});
    }
}