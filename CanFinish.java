import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: CanFinish
 * @description: 207. 课程表
 * @author: Carl Tong
 * @date: 2022/3/12 22:59
 */
public class CanFinish {
    
    boolean hasCycle = false;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses], path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(visited, path, graph, i);
        }
        return !hasCycle;
    }
    
    public void traverse(boolean[] visited, boolean[] path, List<Integer>[] graph, int cur) {
        if (path[cur]) hasCycle = true;
        if (visited[cur] || hasCycle) return;
        visited[cur] = true; path[cur] = true;
        for (int to : graph[cur]) {
            traverse(visited, path, graph, to);
        }
        path[cur] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
