/**
 * @className: NumArray
 * @description: 303. 区域和检索 - 数组不可变
 * @author: Carl Tong
 * @date: 2022/3/16 1:37
 */
public class NumArray {

    // 前缀和数组
    int[] preSum;

    public NumArray(int[] nums) {
        // preSum[0] = 0，便于计算累加和
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        // 要包含 left 和 right 的
        return preSum[right + 1] - preSum[left];
    }

}
