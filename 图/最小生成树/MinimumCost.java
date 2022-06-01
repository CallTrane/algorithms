package 图.最小生成树;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @className: MinimumCost
 * @description: 1135. 最低成本联通所有城市
 * @author: Carl Tong
 * @date: 2022/6/1 12:48
 */
public class MinimumCost {

    int minimumCost(int n, int[][] connections) {
        return Kruskal.kruskal(n, connections);
    }

    // ======================  Kruskal  ============================
    /*
    将所有边按照权重从小到大排序，从权重最小的边开始遍历.
        如果这条边和mst中的其它边不会形成环，则这条边是最小生成树的一部分，将它加入mst集合；
        否则，这条边不是最小生成树的一部分，不要把它加入mst集合。
     */
    private static class Kruskal {
        private static int kruskal(int n, int[][] connections) {
            DisjointSet uf = new DisjointSet(n + 1);
            // 所有边按照权重从小到大排序，从权重最小的边开始遍历
            Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
            int mst = 0;
            for (int[] conn : connections) {
                int u = conn[0], v = conn[1], weight = conn[2];
                if (uf.isConnected(u, v)) continue;
                uf.union(u, v);
                mst += weight;
            }
            // 因为初始时多创了一个节点, 所以是有两棵树
            return uf.count == 2 ? mst : -1;
        }

        static class DisjointSet {
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
            }

            public boolean isConnected(int u, int v) {
                return find(u) == find(v);
            }

            public int count() {
                return count;
            }
        }
    }

}
