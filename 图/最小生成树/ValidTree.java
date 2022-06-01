package 图.最小生成树;

/**
 * @className: ValidTree
 * @description: 261. 以图判树
 * @author: Carl Tong
 * @date: 2022/6/1 11:54
 */
public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            // 如果是同一个连通分量, 还连上边的话, 会形成环
            if (disjointSet.isConnected(u, v)) return false;
            disjointSet.union(u, v);
        }
        // 要保证最后只形成了一棵树，即只有一个连通分量
        return disjointSet.getCount() == 1;
    }

    class DisjointSet {
        int[] parent;
        int count;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
            count = n;
        }

        private int find(int u) {
            if (parent[u] != u)
                // 路径压缩
                parent[u] = find(parent[u]);
            return parent[u];
        }

        public void union(int u, int v) {
            int uRoot = find(u), vRoot = find(v);
            // 如果已经是同一个连通分量
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
