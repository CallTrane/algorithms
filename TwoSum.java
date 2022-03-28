/**
 * @className: TwoSum
 * @description: 167. 两数之和 II - 输入有序数组
 *               剑指 Offer II 006. 排序数组中两个数字之和
 * @author: Carl Tong
 * @date: 2022/3/17 21:31
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            while (numbers[left] + numbers[right] < target) left++;
            while (numbers[left] + numbers[right] > target) right--;
            if (numbers[left] + numbers[right] == target) break;
        }
        return new int[]{left, right};
    }
}
