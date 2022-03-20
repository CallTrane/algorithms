import java.util.Arrays;
import java.util.Comparator;

/**
 * @className: MaxEnvelopes
 * @description: 354. 俄罗斯套娃信封问题
 * @author: Carl Tong
 * @date: 2022/3/11 1:21
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // 有点类似于求最长递增子序列，但是会受到另外一个数组的影响。那么我们先根据一个数组进行排序，对另外一个数组求递增子序列就好了
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> {
            // 这里的意思是，遇到相同的话，另外的数需要倒序排序（因为两个宽度相同的信封不能相互包含的，逆序排序保证最多只选取一个）
            return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
        });
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = envelopes[i][1];
        }
        return lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] tops = new int[n];
        for (int i = 0; i < n; i++) {
            int poker = nums[i], left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (tops[mid] >= poker) right = mid;
                else left = mid + 1;
            }
            if (left == piles) ++piles;
            tops[left] = poker;
        }
        return piles;
    }

    /*public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 0;
        int[] dp = new int[n]; Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/
}
