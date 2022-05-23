import java.util.*;

/**
 * @className: MinCostConnectPoints
 * @description: 1584. 连接所有点的最小费用
 * @author: Carl Tong
 * @date: 2022/3/15 14:51
 */
public class MinCostConnectPoints {

    // ======================== Prim算法 =========================
    public int minCostConnectPoints(int[][] points) {
        List<int[]>[] graph = buildGraph(points);
        Prim prim = new Prim(graph);
        if (prim.isAllConnected()) return prim.getWeightSum();
        return -1;
    }

    private List<int[]>[] buildGraph(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int weight = Math.abs(xi - xj) + Math.abs(yi - yj);
                // 以索引代替下标
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }
        return graph;
    }

    class Prim {
        private PriorityQueue<int[]> queue;
        private int weightSum;
        private boolean[] inMST;
        private List<int[]>[] graph;

        public Prim(List<int[]>[] graph) {
            this.weightSum = 0;
            this.graph = graph;
            inMST = new boolean[graph.length];
            queue = new PriorityQueue<>(Comparator.comparing(i -> i[2]));
            inMST[0] = true; cut(0);
            while (!queue.isEmpty()) {
                int[] edge = queue.poll();
                int from = edge[0], to = edge[1], weight = edge[2];
                if (inMST[to]) continue;
                inMST[to] = true; cut(to);
                weightSum += weight;
            }
        }

        public void cut(int cur) {
            for (int[] edge : graph[cur]) {
                int to = edge[1];
                if (inMST[to]) continue;
                queue.offer(edge);
            }
        }

        public int getWeightSum() {
            return this.weightSum;
        }

        public boolean isAllConnected() {
            for (int i = 0; i < inMST.length; i++) {
                if (!inMST[i]) return false;
            }
            return true;
        }
    }

    // ======================= Kruskal算法 =======================

    /*public int minCostConnectPoints(int[][] points) {
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
        图.DisjointSet disjointSet = new 图.DisjointSet(points.length);
        int res = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (disjointSet.isConnected(u, v)) continue;
            disjointSet.union(u, v);
            res += edge[2];
        }
        return res;
    }

    class 图.DisjointSet {
        private int[] parent;
        private int[] depth;
        private int count;

        public 图.DisjointSet(int n) {
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
    }*/
}
