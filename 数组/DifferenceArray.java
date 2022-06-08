package 数组;

/**
 * @className: DifferenceArray
 * @description: 差分数组
 * @author: Carl Tong
 * @date: 2022/6/8 12:26
 */
public class DifferenceArray {

    private int[] diff;

    public DifferenceArray(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 对区间[i, j]进行操作
     */
    public void change(int i, int j, int val) {
        diff[i] += val;
        // 可能是直接对整个数组操作, 避免越界
        if (j + 1 < diff.length)
            diff[j + 1] -= val;
    }

    public int[] result() {
        int[] nums = new int[diff.length];
        nums[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            nums[i] = diff[i] + nums[i - 1];
        }
        return nums;
    }

}
