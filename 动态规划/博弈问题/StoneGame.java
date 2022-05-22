package 动态规划.博弈问题;

/**
 * @className: StoneGame
 * @description: 877. 石子游戏
 * @author: Carl Tong
 * @date: 2022/5/22 16:53
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j][0] = x : 表示为对于 piles[i...j] 这部分石头堆，先手能获得的最高分数为 x
        // dp[i][j][1] = y : 表示为对于 piles[i...j] 这部分石头堆，后手能获得的最高分数为 y
        int[][][] dp = new int[n][n][2];
        // base case
        for (int i = 0; i < n; i++)
            dp[i][i][0] = piles[i];
        // base case 是斜着的，推算 dp[i][j] 时需要用到 dp[i+1][j] 和 dp[i][j-1]，所以需要倒着转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 先手玩家拿了piles[i]，那么在区间[i + 1, j]只能由后手玩家拿；同理
                int chooseLeft = dp[i + 1][j][1] + piles[i], chooseRight = dp[i][j - 1][1] + piles[j];
                if (chooseLeft < chooseRight) {
                    // 先手玩家选择
                    dp[i][j][0] = chooseRight;
                    // 后手玩家，先手玩家选择最右边的石头堆，给我剩下了piles[i...j+1]，此时轮到我，我变成了先手。
                    dp[i][j][1] = dp[i][j - 1][0];
                } else {
                    dp[i][j][0] = chooseLeft;
                    // 后手玩家，先手玩家选择最左边的石头堆，给我剩下了piles[i+1...j]，此时轮到我，我变成了先手。
                    dp[i][j][1] = dp[i + 1][j][0];
                }
            }
        }
        return dp[0][n - 1][0] - dp[0][n - 1][1] > 0;
    }
}
