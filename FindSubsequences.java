import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: FindSubsequences
 * @description: 491. 递增子序列
 * @author: Carl Tong
 * @date: 2022/2/14 22:32
 */
public class FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index, List<Integer> path) {
        // 如果路径元素大于等于2，则说明有新的递增子序列生成
        if (path.size() > 1) {
            res.add(new ArrayList(path));
        }
        // 一个去重的容器，用于判断之前是否已经生成子序列
        Set<Integer> set = new HashSet<>();
        // 范围继续寻找
        for (int i = index; i < nums.length; i++) {
            // 如果 set 中已经有与 nums[i] 相同的值了，说明该元素的所有可能的递增序列之前已经被搜过一遍了，因此停止继续搜索。
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            // 否则，如果当前元素大于或等于路径末尾元素，则说明出现了新的递增子序列
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                dfs(res, nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
