import java.util.HashMap;
import java.util.Map;

/**
 * @className: SubarraySum
 * @description: 剑指 Offer II 010. 和为 k 的子数组
 * @author: Carl Tong
 * @date: 2022/4/25 19:05
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // 不能使用滑动窗口解法：因为有可能出现负数，当不满足条件时，无法确定收缩窗口还是扩大窗口
        // 用的是前缀和解法（因为需要获取前几次或更多次的结果进行对比时，用哈希表的方式可以压缩时间复杂度）
        Map<Integer, Integer> preSum = new HashMap<>();
        int result = 0, curSum = 0;
        // 为了避免出现第一个数就满足的情况，需要先预存 {0:1} 数据
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (preSum.containsKey(curSum - k)) result += preSum.get(curSum - k);
            preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        }
        return result;
    }
}
