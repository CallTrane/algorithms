package 图.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @className: Dijkstra
 * @description: Dijkstra's algorithm : 解决的是带权重(非负值)的有向图上单源最短路径问题
 *               如果路径中每增加一条边，路径的总权重就会减少，要是能够满足这个条件，也可以用 Dijkstra 算法
 * @author: Carl Tong
 * @date: 2022/5/26 16:41
 */
public class Dijkstra {

    class Node {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        int distFromStart;

        public Node(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    private List<Integer>[] graph;

    // 返回节点 from 到节点 to 之间的边的权重
    private int weight(int from, int to) {
        // 根据问题计算权重
        return 0; // 这里的0是随便写的
    }

    // 输入节点 s, 返回 s 的相邻节点
    private List<Integer> adj(int s) {
        return graph[s];
    }

    // 输入一幅图和一个起点 start，计算 start 到其他节点的最短距离
    public int[] dijkstra(int start, List<Integer>[] graph) {
        // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重 (记录最短路径的权重, 可以理解为 dp table)
        int[] distTo = new int[graph.length];
        // 求最小值，所以 dp table 初始化为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case
        distTo[start] = 0;
        // 优先队列，distFromStart 较小的排在前面
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curNodeId = curNode.id, curNodeDistFromStart = curNode.distFromStart;
            // 如果是可以判断判断终点, 可以这么写 (因为是最小优先队列, 第一次遇到 end 就是最小路径了)
            // if (curNodeId == end) return curNodeDistFromStart;
            // 已经有一条更短的路径到达 curNode 节点了
            if (curNodeDistFromStart > distTo[curNodeId]) continue;
            // 否则, 只知道当前节点更近还不能更新, 需要通过 curNode 节点, 计算到相邻节点的距离会不会更短
            for (int nextNodeId : adj(curNodeId)) {
                int nextNodeDistFromStart = distTo[curNodeId] + weight(curNodeId, nextNodeId);
                // 如果距离可以更短
                if (nextNodeDistFromStart < distTo[nextNodeId]) {
                    // 更新 dp table
                    distTo[nextNodeId] = nextNodeDistFromStart;
                    // 入队
                    pq.offer(new Node(nextNodeId, nextNodeDistFromStart));
                }
            }
        }
        return distTo;
    }
}
