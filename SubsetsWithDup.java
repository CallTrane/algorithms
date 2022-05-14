import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: SubsetsWithDup
 * @description: 90. 子集 II
 * @author: Carl Tong
 * @date: 2022/5/14 22:10
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 记录回溯算法的递归路径
        LinkedList<Integer> track = new LinkedList<>();
        // 先进行排序，让相同的元素靠在一起，如果发现 nums[i] == nums[i-1]，则跳过
        Arrays.sort(nums);
        track(nums, 0, track, res);
        return res;
    }

    private void track(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> res) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            // i > start，是为了避免跳过第一个元素； nums[i] == nums[i - 1] 是剪枝逻辑，只遍历第一条同时跳过其他相同元素的
            if (i > start && nums[i] == nums[i - 1]) continue;
            track.addLast(nums[i]);
            track(nums, i + 1, track, res);
            track.removeLast();
        }
    }
}
