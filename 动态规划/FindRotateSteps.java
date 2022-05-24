package 动态规划;

import java.util.*;

/**
 * @className: FindRotateSteps
 * @description: 514. 自由之路
 * @author: Carl Tong
 * @date: 2022/5/23 20:30
 */
public class FindRotateSteps {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        Map<Character, List<Integer>> charToIndex = new HashMap<>();
        // 将ring上每个字符的索引保存起来，方便后续操作
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            List<Integer> indexes = charToIndex.get(c);
            if (indexes == null) {
                indexes = new ArrayList<>();
                charToIndex.put(c, indexes);
            }
            indexes.add(i);
        }
        // dp[i][j] = x : 定义为圆盘指针在ring[i]时，得到 key[j] 的最少操作数 x
        int[][] dp = new int[m][n];
        // 先填充，方便后续比较最小
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        // base case : 当轮盘刚开始时，转到key的第一个字符时所需要的最少操作数（此时ring的指向也会随之变化）
        List<Integer> indexList = charToIndex.get(key.charAt(0));
        // Math.min(index, m - index) 是判断顺时针还是逆时针转更少，+1是因为按下按钮也算一次操作
        for (int index : indexList) dp[index][0] = 1 + Math.min(index, m - index);
        // 开始推导key的字符
        for (int j = 1; j < n; j++) {
            // 根据当前字符，查找ring中字符的索引位置
            List<Integer> indexes = charToIndex.get(key.charAt(j));
            // 对当前字符的每一个当前下标index
            for (int i : indexes) {
                // 跟上一个字符一个个对比，找出最小操作数的那个
                List<Integer> preIndexes = charToIndex.get(key.charAt(j - 1));
                for (int preIndex : preIndexes) {
                    // 计算从上一个字符，到当前字符的最少操作数
                    int gap = Math.abs(preIndex - i), count = 1 + Math.min(gap, m - gap);
                    // 不断比较，上一次位置到得到当前 key[j] 最少操作数
                    dp[i][j] = Math.min(dp[i][j], dp[preIndex][j - 1] + count);
                }
            }
        }
        // 比较每个转盘位置得到 key 全部字符，最少的操作数
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) ret = Math.min(ret, dp[i][n - 1]);
        return ret;
    }
}
