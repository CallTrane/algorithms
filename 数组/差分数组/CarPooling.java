package 数组.差分数组;

import java.util.Arrays;

/**
 * @className: CarPooling
 * @description: 1094. 拼车
 * @author: Carl Tong
 * @date: 2022/6/8 14:18
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        // 题目限制最多有1001个车站
        int[] nums = new int[1001];
        DifferenceArray diff = new DifferenceArray(nums);
        for (int[] trip : trips) {
            // trip[2]站乘客已经下车, 所以乘客在车上的区间为[trip[1], trip[2] - 1]
            int pass = trip[0], from = trip[1], to = trip[2] - 1;
            diff.change(from, to, pass);
        }
        int[] res = diff.result();
        return Arrays.stream(res).max().getAsInt() <= capacity;
    }

    class DifferenceArray {
        private int[] diff;
        public DifferenceArray(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
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
