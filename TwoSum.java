/**
 * @className: TwoSum
 * @description: 167. 两数之和 II - 输入有序数组
 * @author: Carl Tong
 * @date: 2022/3/17 21:31
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) break;
            else if (sum < target) left++;
            else right--;
        }
        return new int[]{left + 1, right + 1};
    }
}
