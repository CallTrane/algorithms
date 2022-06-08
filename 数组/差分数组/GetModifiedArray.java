package 数组.差分数组;

/**
 * @className: GetModifiedArray
 * @description: 370. 区间加法
 * @author: Carl Tong
 * @date: 2022/6/8 12:44
 */
public class GetModifiedArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        DifferenceArray diff = new DifferenceArray(nums);
        for (int[] update : updates) {
            int i = update[0], j = update[1], val = update[2];
            diff.change(i, j, val);
        }
        return diff.result();
    }

    class DifferenceArray {
        private int[] diff;

        public DifferenceArray(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < diff.length; i++)
                diff[i] = nums[i] - nums[i - 1];
        }

        public void change(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length)
                diff[j + 1] -= val;
        }

        public int[] result() {
            int[] nums = new int[diff.length];
            nums[0] = diff[0];
            for (int i = 1; i < nums.length; i++) {
                nums[i] = diff[i] + nums[i - 1];
            }
            return nums;
        }
    }
}
