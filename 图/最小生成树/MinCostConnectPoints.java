package 图.最小生成树;

import java.util.*;

/**
 * @className: MinCostConnectPoints
 * @description: 1584. 连接所有点的最小费用
 * @author: Carl Tong
 * @date: 2022/3/15 14:51
 */
public class MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        return prim(points);
    }

    // ======================  Kruskal  ============================
    /*
    将所有边按照权重从小到大排序，从权重最小的边开始遍历.
        如果这条边和mst中的其它边不会形成环，则这条边是最小生成树的一部分，将它加入mst集合；
        否则，这条边不是最小生成树的一部分，不要把它加入mst集合。
     */
    private int kruskal(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        // 根据每个节点, 链接到其他节点, 构建边
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new int[]{i, j, weight});
            }
        }
        return Kruskal.kruskal(n, edges);
    }

    private static class Kruskal {
        public static int kruskal(int n, List<int[]> edges) {
            DisjointSet disjointSet = new DisjointSet(n);
            // 所有边按照权重从小到大排序，从权重最小的边开始遍历
            Collections.sort(edges, Comparator.comparingInt(a -> a[2]));
            int mst = 0;
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], weight = edge[2];
                if (disjointSet.isConnected(u, v)) continue;
                disjointSet.union(u, v);
                mst += weight;
            }
            return mst;
        }

        private static class DisjointSet {
            int count;
            int[] parent;
            public DisjointSet(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++)
                    parent[i] = i;
                this.count = n;
            }

            private int find(int u) {
                if (parent[u] != u)
                    parent[u] = find(parent[u]);
                return parent[u];
            }

            public void union(int u, int v) {
                int uRoot = find(u), vRoot = find(v);
                if (uRoot == vRoot) return;
                parent[uRoot] = vRoot;
                count--;
            }

            public boolean isConnected(int u, int v) {
                return find(u) == find(v);
            }

            public int count() {
                return this.count;
            }
        }
    }

    // ======================   Prim   ============================
    /*
    Prim核心 : 切分原理 (「切分」就是将一幅图分为两个不重叠且非空的节点集合，一幅图肯定可以有若干种切分，因为根据切分的定义，只要你能一刀把节点分成两部分就行)
    对于任意一种「切分」，其中权重最小的那条「横切边」一定是构成最小生成树的一条边。为了让最终这棵生成树的权重和最小选权重最小的那条「横切边」
    使用优先队列, 选择最小的一条边
     */
    private int prim(int[][] points) {
        List<int[]>[] graph = buildGraph(points.length, points);
        return Prim.prim(points.length, graph);
    }

    private List<int[]>[] buildGraph(int n, int[][] edges) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new LinkedList<>();
        for (int[] edge : edges) {
            // 题目给的节点编号是从 1 开始的, 这里实现的 Prim 算法是从0开始的
            int from = edge[0] - 1, to = edge[1] - 1, weight = edge[2];
            // 无向图可以理解为双向图
            graph[from].add(new int[]{from, to, weight});
            graph[to].add(new int[]{to, from, weight});
        }
        return graph;
    }

    private static class Prim {
        public static int prim(int n, List<int[]>[] graph) {
            // 最小优先队列
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            // 是否已经在最小生成树中
            boolean[] inMST = new boolean[n];
            // 最小权重
            int mst = 0;
            // 先随便切分一条边
            cut(pq, graph, 0, inMST);
            inMST[0] = true;
            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                int from = edge[0], to = edge[1], weight = edge[2];
                if (inMST[to]) continue;
                cut(pq, graph, to, inMST);
                inMST[to] = true;
                mst += weight;
            }
            // 是否所有节点已经在最小生成树中, 如果不是返回 -1
            return isAllConnected(inMST) ? mst : -1;
        }

        // 切分, 同时把邻边放入优先队列里(已经在最小生成树的节点跳过, 防止重复)
        private static void cut(PriorityQueue<int[]> pq, List<int[]>[] graph, int node, boolean[] inMST) {
            for(int[] edge : graph[node]) {
                int from = edge[0], to = edge[1], weight = edge[2];
                if (inMST[to]) continue;
                pq.offer(edge);
            }
        }

        // 遍历节点, 是否所有节点已经在最小生成树
        private static boolean isAllConnected(boolean[] inMST) {
            for (int i = 0; i < inMST.length; i++)
                if (!inMST[i]) return false;
            return true;
        }
    }
}
