import java.util.LinkedList;
import java.util.List;

/**
 * @className: Combine
 * @description: 77. 组合
 * @author: Carl Tong
 * @date: 2022/5/14 11:48
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        // 记录回溯算法的递归路径
        LinkedList<Integer> track = new LinkedList<>();
        track(n, k, 1, track, res);
        return res;
    }

    private void track(int n, int k, int start, LinkedList<Integer> track, List<List<Integer>> res) {
        // base case, 到达叶子节点
        if (track.size() == k) {
            // 收集叶子节点上的值
            res.add(new LinkedList<>(track));
            return;
        }
        // 回溯算法标准框架
        for (int i = start; i <= n; i++) {
            // 做选择
            track.addLast(i);
            // i 通过 start 参数控制树枝的遍历，避免产生重复的子集
            track(n, k, i + 1, track, res);
            // 撤销选择
            track.removeLast();
        }
    }

}
