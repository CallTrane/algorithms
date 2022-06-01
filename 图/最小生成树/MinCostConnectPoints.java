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

    // ======================  Kruskal  ============================
    /*
    将所有边按照权重从小到大排序，从权重最小的边开始遍历.
        如果这条边和mst中的其它边不会形成环，则这条边是最小生成树的一部分，将它加入mst集合；
        否则，这条边不是最小生成树的一部分，不要把它加入mst集合。
     */
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
}
