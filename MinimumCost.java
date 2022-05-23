import java.util.*;

/**
 * @className: MinimumCost
 * @description: 1135. 最低成本联通所有城市
 * @author: Carl Tong
 * @date: 2022/3/15 12:48
 */
public class MinimumCost {

    // ========================== Prim 解法 ===========================
    public int minimumCost(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);
        if (prim.isAllConnected()) return prim.getWeightSum();
        return -1;
    }

    private List<int[]>[] buildGraph(int n, int[][] edges) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            // 题目给的节点编号是从 1 开始的，但我们实现的 Prim 算法需要从 0 开始编号
            int from = edge[0] - 1, to = edge[1] - 1, weight = edge[3];
            // 无向图 == 双向图
            graph[from].add(new int[]{from, to, weight});
            graph[to].add(new int[]{to, from ,weight});
        }
        return graph;
    }

    class Prim {
        private PriorityQueue<int[]> queue;
        private int weightSum;
        private boolean[] inMST;
        private List<int[]>[] graph;

        public Prim(List<int[]>[] graph) {
            this.graph = graph;
            this.weightSum = 0;
            this.queue = new PriorityQueue<>(Comparator.comparing(i -> i[2]));
            this.inMST = new boolean[graph.length];
            inMST[0] = true; cut(0);
            while (!queue.isEmpty()) {
                int[] edge = queue.poll();
                int from = edge[0], to = edge[1], weight = edge[3];
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

    // ========================= Kruskal 解法 =========================

    /*public int minimumCost(int n, int[][] connections) {
        图.DisjointSet disjointSet = new 图.DisjointSet(n + 1);
        // 先按照权重从小到大排序，下面一步步从小到大连通
        Arrays.sort(connections, Comparator.comparingInt(i -> i[2]));
        int cost = 0;
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            if (disjointSet.isConnected(u, v)) continue;
            disjointSet.union(u, v);
            cost += edge[2];
        }
        // 本来是 count == 1 说明所有结点连通，但因为上面构建的时候多了个0， 所以是2
        return disjointSet.getCount() == 2 ? cost : -1;
    }

    class 图.DisjointSet {
        int[] parent;
        int[] depth;
        int count;

        public 图.DisjointSet(int n) {
            this.count = n;
            this.parent = new int[n];
            this.depth = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                depth[i] = i;
            }
        }

        public int findSet(int x) {
            while (parent[x] != x) {
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
            count--;
        }

        public boolean isConnected(int x, int y) {
            return findSet(x) == findSet(y);
        }

        public int getCount() {
            return this.count;
        }
    }*/
}
