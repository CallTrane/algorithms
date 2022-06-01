package 图.最小生成树;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @className: Kruskal
 * @description: 最小生成树   1.包含图中的所有节点; 2.形成的结构是树结构(即不存在环); 3.权重和最小
 * @author: Carl Tong
 * @date: 2022/6/1 1:03
 */
public class Kruskal {
    /*
    将所有边按照权重从小到大排序，从权重最小的边开始遍历.
        如果这条边和mst中的其它边不会形成环，则这条边是最小生成树的一部分，将它加入mst集合；
        否则，这条边不是最小生成树的一部分，不要把它加入mst集合。
     */
    public int kruskal(int n, List<int[]> edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        // 所有边按照权重从小到大排序，从权重最小的边开始遍历
        Collections.sort(edges, Comparator.comparingInt(a -> a[2]));
        int mst = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            // 如果已经是同一连通分量, 跳过 (否则会形成环)
            if (disjointSet.isConnected(u, v)) continue;
            disjointSet.union(u, v);
            mst += weight;
        }
        // 判断是不是形成一棵最小生成树, 是的话返回最小权重和, 不是返回-1
        return disjointSet.count == 1 ? mst : -1;
    }

    private class DisjointSet {
        int count;
        int[] parent;
        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
            this.count = n;
        }

        private int find(int u) {
            if (u != parent[u])
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

        public int getCount() {
            return this.count;
        }
    }
}
