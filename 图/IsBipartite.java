package 图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: IsBipartite
 * @description: 785. 判断二分图
 * @author: Carl Tong
 * @date: 2022/3/14 21:06
 */
public class IsBipartite {
    boolean res = true;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n], color = new boolean[n];
        // 图不一定是全联通的，可能存在子图；如果发现任意一个子图不是二分图，则整个图都不是二分图，所以要遍历每个结点
        for (int i = 0; i < n; i++) {
            if (!visited[i] && res) bfs(graph, visited, color, i);
        }
        return res;
    }

    public void traverse(int[][] graph, boolean[] visited, boolean[] color, int node) {
        if (!res) return;
        visited[node] = true;
        for (int next : graph[node]) {
            // 如果已经被访问过，则要判断颜色是不是相同的
            if (visited[next]) {
                if (color[next] = color[node]) {
                    res = false;
                    return;
                }
            // 如果还没被访问过，着色
            } else {
                color[next] = !color[node];
                traverse(graph, visited, color, next);
            }
        }
    }

    public void bfs(int[][] graph, boolean[] visited, boolean[] color, int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);
        while (!queue.isEmpty() && res) {
            // 直接向全节点扩散
            int cur = queue.poll();
            for (int next : graph[cur]) {
                // 如果已经被访问过了，判断颜色是否相同
                if (visited[next]) {
                    if (color[next] == color[cur]) {
                        res = false;
                        return;
                    }
                // 没被访问过，着色
                } else {
                    visited[next] = true;
                    queue.offer(next);
                    color[next] = !color[cur];
                }
            }
        }
    }
}
