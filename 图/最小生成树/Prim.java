package 图.最小生成树;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @className: Prim
 * @description: Prim 最小生成树
 *               最小生成树（1.包含图中的所有节点; 2.形成的结构是树结构(即不存在环); 3.权重和最小）
 * @author: Carl Tong
 * @date: 2022/6/1 17:09
 */
public class Prim {
    /*
    Prim核心 : 切分原理 (「切分」就是将一幅图分为两个不重叠且非空的节点集合，一幅图肯定可以有若干种切分，因为根据切分的定义，只要你能一刀把节点分成两部分就行)
    对于任意一种「切分」，其中权重最小的那条「横切边」一定是构成最小生成树的一条边。为了让最终这棵生成树的权重和最小选权重最小的那条「横切边」
    使用优先队列, 选择最小的一条边
     */
    // 三元组 int[]{from, to, weight} 表示一条边, (graph 是用邻接表表示的一幅图, graph[s] 记录节点 s 所有相邻的边)
    public int prim(int n, List<int[]>[] graph) {
        // 类似 visited 数组的作用，记录哪些节点已经成为最小生成树的一部分, 防止重复计算横切边(例如 cut({A, B}) 的横切边和 cut({C}) 的横切边中 BC 边重复了)
        boolean[] inMST = new boolean[n];
        // 记录最小生成树的权重和
        int mst = 0;
        // 核心数据结构，存储「横切边」的最小优先队列(按权重升序排序, 找权重最小的横切边)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // 随便从一个点开始切分都可以, 这里是从0开始切
        inMST[0] = true;
        cut(graph, pq, inMST, 0);
        // 不断进行切分, 向最小生成树添加边
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int from = edge[0], to = edge[1], weight = edge[2];
            // 如果相邻节点已经在最小生成树中, 跳过(否则会产生环)
            if (inMST[to]) continue;
            // 将这条边加入最小生成树
            inMST[to] = true;
            mst += weight;
            // 根据加入的这个节点, 添加新的横切边
            cut(graph, pq, inMST, to);
        }
        // 如果所有节点已经连通生成最小生成树, 则返回最小权重和; 否则返回-1
        return isAllConnected(inMST) ? mst : -1;
    }

    // 将 node 的横切边加入优先队列
    private void cut(List<int[]>[] graph, PriorityQueue<int[]> pq, boolean[] inMST, int node) {
        // 遍历节点 node 的邻边, 把邻边加进优先队列
        for (int[] edge : graph[node]) {
            int from = edge[0], to = edge[1], weight = edge[2];
            // 如果相邻节点已经在最小生成树中, 跳过(否则会产生环)
            if (inMST[to]) continue;
            // 将这条边加入最小优先队列
            pq.offer(edge);
        }
    }

    private boolean isAllConnected(boolean[] inMST) {
        for (int i = 0; i < inMST.length; i++)
            if (!inMST[i]) return false;
        return true;
    }

}
