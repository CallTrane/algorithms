/**
 * @className: LargestSumOfAverages
 * @description: 813. 最大平均值和的分组
 * @author: carl
 * @date: 2021/9/10 21:24
 */

/**
 * dp[天数][已分割多少份]
 * sum[i] 0~i天所有的数的总和
 */
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return 0;
        }
        int length = nums.length;
        double[] sum = new double[length+1];
        double[][] dp = new double[length+1][k+1];

        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }

        //以某天作为一个截止
        for (int i = 1; i <= length; i++) {
            dp[i][1] = sum[i] / i;
            for (int count = 2; count <= k && count <= i; count++) {
                // 第一天 --》 截止的这一天，分割
                for (int j = 1; j < i; j++) {
                    dp[i][count] = Math.max(dp[i][count], dp[j][count-1] + (sum[i]-sum[j]) / (i-j));
                }
            }
        }
        return dp[length][k];
    }
}
