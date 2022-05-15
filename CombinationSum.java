import java.util.LinkedList;
import java.util.List;

/**
 * @className: CombinationSum
 * @description: 39. 组合总和
 * @author: Carl Tong
 * @date: 2022/5/15 10:52
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        // 记录回溯路径
        LinkedList<Integer> track = new LinkedList<>();
        track(candidates, target, 0, track, 0, ret);
        return ret;
    }

    private void track(int[] nums, int target, int start, LinkedList<Integer> track, int trackSum, List<List<Integer>> ret) {
        // base case
        if (trackSum == target) {
            ret.add(new LinkedList<>(track));
            return;
        }
        // base case : 路径和大于 target 时就没必要再遍历下去
        if (trackSum > target) return;
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]); trackSum += nums[i];
            // 回溯 （可复选的情况，如果想让每个元素被重复使用，只要把 i + 1 改成 i 即可）
            track(nums, target, i, track, trackSum, ret);
            // 撤销选择
            track.removeLast(); trackSum -= nums[i];
        }
    }
}
