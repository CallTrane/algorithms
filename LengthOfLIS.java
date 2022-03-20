import java.util.Arrays;

/**
 * @className: LengthOfLIS
 * @description: 300. 最长递增子序列
 * @author: carl
 * @date: 2021/8/10 22:26
 */
public class LengthOfLIS {

    // 二分查找解法（纸牌游戏 : patience game）（耐心排序 : patience sorting）
    public int lengthOfLIS(int[] nums) {
        // 保存堆顶的值
        int[] piles = new int[nums.length];
        // 计算牌堆数，堆数就是答案
        int pileCount = 0;
        for (int i = 0; i < nums.length; i++) {
            // 这里的有效堆索引为 left ~ pileCount - 1，将right置为pileCount是因为当left == pileCount的时候说明跳出范围，需要创建新的牌堆
            int left = 0, right = pileCount, curPoker = nums[i];
            // 牌顶有序，用二分查找放入哪个堆
            while (left < right) {
                int mid = (left + right) >> 1;
                if (piles[mid] >= curPoker) right = mid;
                else left = mid + 1;
            }
            // 如果没有找到，新建一个牌堆
            if (left == pileCount) pileCount++;
            // 每张牌都要放到堆顶
            piles[left] = curPoker;
        }
        return pileCount;
    }

    // 动态规划解法
    /*public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 1;
        // 1、状态定义
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 2、状态转移方程
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        // search result
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/
}
