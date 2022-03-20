import java.util.*;

/**
 * @className: Permute
 * @description: 46. 全排列
 * @author: carl
 * @date: 2021/9/5 0:48
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        if (length <= 0 || nums == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList();
        Deque<Integer> path = new ArrayDeque();
        boolean[] used = new boolean[length];

        dfs(nums, 0, path, result, used);
        return result;
    }

    void dfs(int[] nums, int depth, Deque<Integer> path, List<List<Integer>> result, boolean[] used) {
        if (depth == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, depth+1, path, result, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
