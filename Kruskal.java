import java.util.*;

/**
 * @className: Kruskal
 * @description: Kruskal 最小生成树算法
 * @author: Carl Tong
 * @date: 2022/3/15 18:59
 */
public class Kruskal {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        // 计算每个结点之间的距离
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                // 用索引代替下标(x, y)
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
        // 根据权重从小到大排序
        Collections.sort(edges, Comparator.comparingInt(i -> i[2]));
        // 执行 Kruskal 算法
        DisjointSet disjointSet = new DisjointSet(points.length);
        int res = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (disjointSet.isConnected(u, v)) continue;
            disjointSet.union(u, v);
            res += edge[2];
        }
        return res;
    }

    class DisjointSet {
        private int[] parent;
        private int[] depth;
        private int count;

        public DisjointSet(int n) {
            this.count = n;
            this.parent = new int[n];
            this.depth = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                depth[i] = 1;
            }
        }

        public int findSet(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = findSet(x), yRoot = findSet(y);
            if (xRoot == yRoot) return;
            if (depth[xRoot] <= depth[yRoot]) {
                parent[xRoot] = yRoot;
                if (depth[xRoot] == depth[yRoot]) depth[yRoot]++;
            } else {
                parent[yRoot] = xRoot;
            }
        }

        public boolean isConnected(int x, int y) {
            return findSet(x) == findSet(y);
        }

        public int getCount() {
            return this.count;
        }
    }
}
