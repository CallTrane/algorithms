package 动态规划;

import java.util.PriorityQueue;

/**
 * @className: MinRefuelStops
 * @description: 871. 最低加油次数
 * @author: Carl Tong
 * @date: 2022/7/2 18:41
 */
public class MinRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return greedyPriority(target, startFuel, stations);
    }

    /**
     * 贪心算法：最大优先队列。每次经过加油站的时候把油带起来，当没油的时候从自身带的油中选取最大的油量。
     * 时间复杂度 nlogn
     */
    public int greedyPriority(int target, int startFuel, int[][] stations) {
        // 最大优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int count = 0, curFuel = startFuel, i = 0;
        while (curFuel < target) {
            // 当油量足够通过当前加油站的时候, 直接带走油
            if (i < stations[i].length && curFuel >= stations[i][0])
                pq.offer(stations[i++][1]);
            // 否则无法到达, 需要从已经带走的油中选取最大油量的加油
            else {
                // 如果已经没了, 则无法到达
                if (pq.isEmpty()) return -1;
                curFuel += pq.poll();
                count++;
            }
        }
        return count;
    }

    /**
     * 动态规划解法
     * 时间复杂度 n^2
     */
    public int dynamic(int target, int startFuel, int[][] stations) {
        // dp[i] = x : 定义为当加油i次的时候，总共有x的油量
        int[] dp = new int[stations.length + 1];
        // base case
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; i++) {
            /*
            当遍历到加油站 stations[i] 的时候，都是将加油站 stations[i] 作为最后一次加油的加油站，
            加油站 stations[i] 只会被计算一次，应该按照从大到小的顺序遍历下标 j
             */
            for (int j = i; j >= 0; j--) {
                // 油量必须足够到达此加油站才能更新
                if (dp[j] >= stations[i][0])
                    // 加一次油后选最大油量的
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
            }
        }
        for (int i = 0; i < dp.length; i++)
            // 从小到大开始，如果出现第一个满足的即为答案
            if (dp[i] >= target) return i;
        return -1;
    }
}
