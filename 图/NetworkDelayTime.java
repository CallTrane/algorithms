package 图;

import java.util.*;

/**
 * @className: NetworkDelayTime
 * @description: 743. 网络延迟时间
 * @author: Carl Tong
 * @date: 2022/5/30 19:53
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 构建图
        List<int[]>[] graph = buildGraph(times, n);
        // dijkstra 算法, 计算无负值权重单源路径
        int[] distTo = dijkstra(k, graph);
        // 找到最长的那一条最短路径
        int res = Arrays.stream(distTo, 1, distTo.length).max().getAsInt();
        // 如果有到达不了的, 返回-1
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private List<int[]>[] buildGraph(int[][] times, int n) {
        // 这里编号是从 1 开始的
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList();
        }
        for (int[] time : times) {
            int from = time[0], to = time[1], weight = time[2];
            graph[from].add(new int[]{to, weight});
        }
        return graph;
    }

    private class Node {
        int id;
        int distFromStart;

        public Node(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    private int[] dijkstra(int start, List<int[]>[] graph) {
        // 节点 start 到达节点 i 的最短路径权重 (记录最短路径的权重, 可以理解为 dp table)
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case
        distTo[start] = 0;
        // 最小优先队列, distFromStart 较小的排在前面
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curNodeId = curNode.id, curNodeDistFromStart = curNode.distFromStart;
            // 如果已经有其他更短的路径, 则跳过
            if (curNodeDistFromStart > distTo[curNodeId]) continue;
            // 否则, 尝试在相邻节点中, 找到更短路径
            for (int[] adj : graph[curNodeId]) {
                int nextNodeId = adj[0], nextNodeDistFromCur = adj[1];
                int nextNodeDistFromStart = distTo[curNodeId] + nextNodeDistFromCur;
                // 如果有更短的路径
                if (distTo[nextNodeId] > nextNodeDistFromStart) {
                    // 更新dp
                    distTo[nextNodeId] = nextNodeDistFromStart;
                    // 入队
                    pq.offer(new Node(nextNodeId, nextNodeDistFromStart));
                }
            }
        }
        return distTo;
    }
}
