package 图.dijkstra;

import java.util.*;

/**
 * @className: MaxProbability
 * @description: 1514. 概率最大的路径
 * @author: Carl Tong
 * @date: 2022/5/31 17:17
 */
public class MaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = buildGraph(edges, succProb, n);
        return dijkstra(graph, start, end);
    }

    // 计算最长路径，路径中每增加一条边，路径的总权重就会减少，要是能够满足这个条件，也可以用 Dijkstra 算法
    private double dijkstra(List<double[]>[] graph, int start, int end) {
        // probTo[i] = x : 定义从 start 开始到 i 的概率为 x
        double[] probTo = new double[graph.length];
        Arrays.fill(probTo, Double.MIN_VALUE);
        // 最大优先队列
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        // base case
        probTo[start] = 1;
        pq.offer(new Node(start, 1));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curId = curNode.id;
            double curProbability = curNode.probability;
            // 如果遇到 end, 因为是最大优先队列, 此时第一次遇到的一定是最大概率的
            if (curId == end) return curProbability;
            // 如果已经遇见其他概率更大的了, 跳过
            if (probTo[curId] > curProbability) continue;
            // 否则, 根据当前节点尝试去相邻节点
            for (double[] neighbor : graph[curId]) {
                int nextId = (int) neighbor[0];
                double probability = neighbor[1];
                double nextProbability = probTo[curId] * probability;
                // 如果发现概率更大的
                if (nextProbability > probTo[nextId]) {
                    // 更新dp
                    probTo[nextId] = nextProbability;
                    // 入队
                    pq.offer(new Node(nextId, nextProbability));
                }
            }
        }
        // 如果遇不到
        return 0.0;
    }

    private class Node {
        // 节点id
        int id;
        // 概率
        double probability;
        public Node(int id, double probability) {
            this.id = id;
            this.probability = probability;
        }
    }

    private List<double[]>[] buildGraph(int[][] edges, double[] succProb, int n) {
        List<double[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            // 无向图相当于双向图
            graph[node1].add(new double[]{(double) node2, succProb[i]});
            graph[node2].add(new double[]{(double) node1, succProb[i]});
        }
        return graph;
    }
}
