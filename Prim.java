import java.util.*;

/**
 * @className: Prim
 * @description: Prim 最小生成树算法
 * @author: Carl Tong
 * @date: 2022/3/15 19:00
 */
public class Prim {
    // 核心数据结构，存储「横切边」的优先级队列
    private PriorityQueue<int[]> queue;
    // 类似 visited 数组的作用，记录哪些节点已经成为最小生成树的一部分
    private boolean[] inMST;
    // 记录最小生成树的权重和
    private int weightSum;
    // 保存图结构 int[]{from, to, weight} 为一条边
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {
        this.weightSum = 0;
        this.graph = graph;
        // 队列里根据权重从小到大排序
        this.queue = new PriorityQueue<>(Comparator.comparing(i -> i[2]));
        // 有 n 个结点
        this.inMST = new boolean[graph.length];
        // 从哪个结点开始切都可以
        inMST[0] = true; cut(0);
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int from = edge[0], to = edge[1], weight = edge[2];
            if (inMST[to]) continue;
            inMST[to] = true; cut(to);
            weightSum += weight;
        }
    }

    // 当 cur 的横切边加入优先队列中
    public void cut(int cur) {
        for (int[] edge : graph[cur]) {
            int to = edge[1];
            // 如果已经在最小生成树中，则跳过
            if (inMST[to]) continue;
            queue.offer(edge);
        }
    }

    public boolean isAllConnected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) return false;
        }
        return true;
    }

    public int getWeightSum() {
        return this.weightSum;
    }
}
