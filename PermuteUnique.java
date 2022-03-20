import java.util.*;

/**
 * @className: PermuteUnique
 * @description: 47. 全排列 II
 * @author: carl
 * @date: 2021/9/5 1:31
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        if (length <= 0 || nums == null) {
            return null;
        }
        Arrays.sort(nums);
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
            if (used[i]) {
                continue;
            }
            /**
             * i > 0 ：为了让nums[i-1]有意义
             * nums[i] == nums[i-1] && !used[i] ：上一个元素相同，且被撤销（说明下一组相同，直接剪枝）
             */
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depth+1, path, result, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
