package 前缀和;

import java.util.Random;

/**
 * @className: RandomlySelected
 * @description: 528. 按权重随机选择
 * @author: Carl Tong
 * @date: 2022/5/26 15:31
 */
public class RandomlySelected {

    private int min, max;

    private static Random RANDOM = null;

    private int[] preSum;

    public RandomlySelected(int[] w) {
        RANDOM = new Random();
        // 多出一个位置, 便于计算前缀和 preSum[i] = nums[0] + nums[1] + ... + nums[i - 1]
        preSum = new int[w.length + 1];
        for (int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] + w[i - 1];
        // 根据题目，最小值为1;
        min = 1; max = preSum[preSum.length - 1];
    }

    public int pickIndex() {
        // target 的取值范围为 [min, max], 在取值区间内随机找一个
        int target = min + RANDOM.nextInt(max);
        // 这里返回的是preSum数组的下标, 与原数组偏移1
        return leftBound(preSum, target) - 1;
    }

    // 二分查找求左侧边界（ >= target 的最小索引）
    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        // 左闭右开寻找 [left, right)
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 收缩上区间，找到最左边界
            if (nums[mid] == target)
                right = mid;
            else if (nums[mid] > target)
                right = mid;
            else if (nums[mid] < target)
                left = mid + 1;
        }
        // 这里不会发生越界问题，直接返回
        return left;
    }
}

class TestRandomlySelected {
    public static void main(String[] args) {
        System.out.println(new RandomlySelected(new int[]{1}).pickIndex());
    }
}
