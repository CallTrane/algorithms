package 回溯;

import java.util.*;

/**
 * @className: 回溯.PermuteUnique
 * @description: 47. 全排列 II
 * @author: carl
 * @date: 2021/9/5 1:31
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        // 回溯路径
        LinkedList<Integer> track = new LinkedList<>();
        // 排列需要的辅助数组
        boolean[] used = new boolean[nums.length];
        // 先进行排序，让相同的元素靠在一起，如果发现 candidates[i] == candidates[i-1]，则跳过
        Arrays.sort(nums);
        track(nums, used, track, ret);
        return ret;
    }

    private void track(int[] nums, boolean[] used, LinkedList<Integer> track, List<List<Integer>> ret) {
        if (track.size() == nums.length) {
            ret.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // i > 0，是为了避免跳过第一个元素； nums[i] == nums[i - 1] 是剪枝逻辑，只遍历第一条同时跳过其他相同元素的
            // 加上 !used[i - 1] 是为了避免上一个相同元素拿了，下一个元素拿不到（比如 1 2 2，拿了 1 2 之后需要继续拿到2）
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            // 做选择
            track.addLast(nums[i]); used[i] = true;
            // 回溯
            track(nums, used, track, ret);
            // 撤销选择
            track.removeLast(); used[i] = false;
        }
    }
}
