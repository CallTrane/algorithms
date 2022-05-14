import java.util.*;

/**
 * @className: Permute
 * @description: 46. 全排列
 * @author: carl
 * @date: 2021/9/5 0:48
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 记录回溯算法的递归路径
        LinkedList<Integer> track = new LinkedList<>();
        // 记录哪些元素被使用过
        boolean[] used = new boolean[nums.length];
        track(nums, used, track, res);
        return res;
    }

    private void track(int[] nums, boolean[] used, LinkedList<Integer> track, List<List<Integer>> res) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // 做选择
            track.addLast(nums[i]); used[i] = true;
            track(nums, used, track, res);
            // 撤销选择
            track.removeLast(); used[i] = false;
        }
    }

}
