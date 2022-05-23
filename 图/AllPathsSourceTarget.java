package 图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: AllPathsSourceTarget
 * @description: 797. 所有可能的路径
 * @author: Carl Tong
 * @date: 2022/3/12 21:45
 */
public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(res, new LinkedList<>(), graph, 0);
        return res;
    }

    private void traverse(List<List<Integer>> res, LinkedList<Integer> path, int[][] graph, int cur) {
        path.add(cur);
        if (cur == graph.length - 1) {
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int node : graph[cur]) {
            traverse(res, path, graph, node);
        }
        // 回溯算法的「做选择」和「撤销选择」在 for 循环里面，而对 onPath 数组的操作在 for 循环外面
        path.removeLast();
    }
}
