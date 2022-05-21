package 数组;

/**
 * @className: RepeatedNTimes
 * @description: 961. 在长度 2N 的数组中找出重复 N 次的元素
 * @author: Carl Tong
 * @date: 2022/5/21 10:58
 */
public class RepeatedNTimes {
    public int repeatedNTimes(int[] nums) {
        // 根据题目，如果相邻的 x 之间至少都隔了 2 个位置，那么数组的总长度至少为 : n+2(n−1) = 3n−2
        // 当 n > 2 时，3n−2 > 2n，不满足题目要求的数组
        // 当 n = 2 时，数组的长度最多为 2n = 4，因此最多只能隔 2 个位置。
        for (int i = 0; i < nums.length; i++) {
            // 判断相邻
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) return nums[i];
            // 判断隔一个位置的
            if (i + 2 < nums.length && nums[i] == nums[i + 2]) return nums[i];
            // 判断隔两个位置的
            if (i + 3 < nums.length && nums[i] == nums[i + 3]) return nums[i];
        }
        // 根据题意：这里是绝对不会出现的
        return Integer.MAX_VALUE;
    }
}
