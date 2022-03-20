import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @className: PossibleBipartition
 * @description: 886. 可能的二分法
 * @author: Carl Tong
 * @date: 2022/3/14 21:59
 */
public class PossibleBipartition {

    private boolean res = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n + 1, dislikes);
        boolean[] visited = new boolean[n + 1], color = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && res) bfs(graph, visited, color, i);
        }
        return res;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] res = new List[n];
        for (int i = 0; i < n; i++) {
            res[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            // 无向图相等于双向图
            res[from].add(to);
            res[to].add(from);
        }
        return res;
    }

    private void bfs(List<Integer>[] graph, boolean[] visited, boolean[] color, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty() && res) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (visited[next]) {
                    if (color[next] == color[cur]) {
                        res = false;
                        return;
                    }
                } else {
                    visited[next] = true;
                    queue.offer(next);
                    color[next] = !color[cur];
                }
            }
        }
    }
}
