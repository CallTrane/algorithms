/**
 * @className: SortArray
 * @description: 912. 排序数组
 * @author: Carl Tong
 * @date: 2022/3/17 21:59
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        MergeSort.sort(nums);
        return nums;
    }
}
