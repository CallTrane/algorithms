package 图.dijkstra;

import java.util.*;

/**
 * @className: MinimumEffortPath
 * @description: 1631. 最小体力消耗路径
 * @author: Carl Tong
 * @date: 2022/5/31 11:49
 */
public class MinimumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        return dijkstra(heights);
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 返回坐标 (x, y) 的上下左右相邻坐标
    private List<int[]> adj(int[][] heights, int x, int y) {
        // 存储相邻节点
        List<int[]> neighbors = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            // 越界
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    class Node {
        int x, y, distFromStart;
        public Node(int x, int y, int distFromStart) {
            this.x = x;
            this.y = y;
            this.distFromStart = distFromStart;
        }
    }

    private int dijkstra(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // effortTo[i][j] = x 定义 : 从 (0, 0) 到 (i, j) 的最少消耗体力为 x
        int[][] effortTo = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        // base case
        effortTo[0][0] = 0;
        // 最小优先队列
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
        pq.offer(new Node(0, 0, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curX = curNode.x, curY = curNode.y, curDistFromStart = curNode.distFromStart;
            // 因为是最小优先队列, 所以第一个遇到的就已经是最少消耗的了, 直接返回
            if (curX == m - 1 && curY == n - 1)
                return effortTo[m - 1][n - 1];
            // 如果已经有更短的路径了
            if (curDistFromStart > effortTo[curX][curY]) continue;
            // 否则, 尝试遍历相邻下一个节点
            for (int[] neighbor : adj(heights, curX, curY)) {
                int nextX = neighbor[0], nextY = neighbor[1];
                // 计算下一个消耗体力
                int nextEffort = Math.max(effortTo[curX][curY], Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                // 如果更少的话
                if (effortTo[nextX][nextY] > nextEffort) {
                    // 更新dp
                    effortTo[nextX][nextY] = nextEffort;
                    // 入队
                    pq.offer(new Node(nextX, nextY, nextEffort));
                }
            }
        }
        // 这是不可能到达的, 会在while循环内提前返回
        return -1;
    }
}
