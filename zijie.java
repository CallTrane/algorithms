import java.util.*;

public class zijie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        for (int i = 0; i < m; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            nums[key] = value;
        }
        int index = n - 1;
        for (; index >= 0; index--) {
            if (nums[index] != -1) {
                break;
            }
        }
        int[] dp = new int[index + 1];
        dp[index] = nums[index] * (n - index);
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] == -1) {
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            dp[i] = nums[i] * (n - i);
            for (int j = i + 1; j <= index; j++) {
                if (dp[j] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], (j - i) * nums[i] + dp[j]);
            }
        }
        System.out.println(dp[0]);
        System.out.println(Arrays.toString(dp));
    }
}