package 数组.差分数组;

/**
 * @className: CorpFlightBookings
 * @description: 1109. 航班预订统计
 * @author: Carl Tong
 * @date: 2022/6/8 12:55
 */
public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        DifferenceArray diff = new DifferenceArray(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1, j = booking[1] - 1, val = booking[2];
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
            if (j + 1 < diff.length) diff[j + 1] -= val;
        }

        public int[] result() {
            int[] nums = new int[diff.length];
            nums[0] = diff[0];
            for (int i = 1; i < nums.length; i++)
                nums[i] = diff[i] + nums[i - 1];
            return nums;
        }
    }
}
