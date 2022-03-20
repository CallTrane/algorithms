import java.util.Arrays;

/**
 * @className: GetLeastNumbers
 * @description: 剑指 Offer 40. 最小的k个数
 * @author: carl
 * @date: 2021/9/4 18:18
 */
public class GetLeastNumbers {

    int k;

    public int[] getLeastNumbers(int[] arr, int k) {
        this.k = k;
        quickSort(arr, 0, arr.length-1);
        return Arrays.copyOf(arr, k);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (end - start <= 0 || nums.length <= 0 || nums == null) {
            return;
        }
        int index = getIndex(nums, start, end);
        if (index > k) {
            quickSort(nums, start, index-1);
        } else if (index < k) {
            quickSort(nums, index+1, end);
        } else {
            return;
        }

    }

    public int getIndex(int[] nums, int start, int end) {
        int left = start, right = end;
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= tmp) {
                right--;
            }
            while (left < right && nums[left] <= tmp) {
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        nums[start] = nums[left];
        nums[left] = tmp;
        return left;
    }
}
