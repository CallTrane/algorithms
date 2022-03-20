import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @className: FindOrder
 * @description: 210. 课程表 II
 * @author: Carl Tong
 * @date: 2022/3/13 1:52
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        Queue<Integer> queue = new LinkedList<>();
        int[] indgree = new int[numCourses], res = new int[numCourses];
        // 初始化入度数组
        for (int i = 0; i < numCourses; i++) {
            for (int in : graph[i]) {
                indgree[in]++;
            }
        }
        // 把入度为0的结点都入队列
        for (int i = 0; i < numCourses; i++) {
            if (indgree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[count] = node;
            count++;
            // 把入度为0的结点出队后，处理跟该结点相关的
            for (int next : graph[node]) {
                indgree[next]--;
                if (indgree[next] == 0) queue.offer(next);
            }
        }
        // 如果不相等，说明是有环的，拓扑排序不存在
        if (count != numCourses) return new int[]{};
        return res;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    // ========================= DFS版本 =========================
    /*private boolean isCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses], path = new boolean[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            traverse(visited, path, graph, i, queue);
        }
        if (isCycle) return new int[]{};
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // 因为这里的队列定义的是被依赖关系，即从前往后是，深依赖 -> 浅依赖，拓扑排序深依赖要放在后面执行，所以从后往前开始弹出
            res[i] = queue.removeLast();
        }
        return res;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1], to = prerequisites[i][0];
            graph[from].add(to);
        }
        return graph;
    }

    private void traverse(boolean[] visited, boolean[] path, List<Integer>[] graph, int cur, Queue<Integer> queue) {
        if (path[cur]) isCycle = true;
        if (visited[cur] || isCycle) return;
        path[cur] = true; visited[cur] = true;
        // 根据依赖关系往下找
        for (int to : graph[cur]) {
            traverse(visited, path, graph, to, queue);
        }
        // 拓扑排序的基础是后续遍历，因为一个任务必须等到它依赖的所有任务都完成之后才能开始执行。这里边定义为【被依赖】关系（from -> to），所以这里添加进来的是最深的结点
        queue.offer(cur);
        path[cur] = false;
    }*/
}