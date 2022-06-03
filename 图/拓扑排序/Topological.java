package 图.拓扑排序;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @className: Topological
 * @description: 拓扑排序
 * @author: Carl Tong
 * @date: 2022/6/4 0:51
 */
public class Topological {
    // BFS队列版本的拓扑排序
    public int[] findOrder(int n, List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        // 入度数组
        int[] inDegree = new int[n];
        // 遍历每个节点的指向, 初始入度数组
        for (int i = 0; i < n; i++) {
            for (int in : graph[i]) {
                inDegree[in]++;
            }
        }
        // 把入度为0的节点加入队列
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0) queue.offer(i);
        // 记录处理过了多少个节点
        int count = 0;
        int[] res = new int[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[count] = node;
            count++;
            // 该节点加入到顺序后, 处理与该节点有关的边的入度
            for (int next : graph[node]) {
                inDegree[next]--;
                // 把入度为0的节点加入队列
                if (inDegree[next] == 0) queue.offer(next);
            }
        }
        return count == n ? res : new int[]{};
    }
}
