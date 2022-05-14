import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: CombinationSum2
 * @description: 40. 组合总和 II
 * @author: Carl Tong
 * @date: 2022/5/14 22:24
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 记录回溯算法的递归路径
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;
        // 先进行排序，让相同的元素靠在一起，如果发现 candidates[i] == candidates[i-1]，则跳过
        Arrays.sort(candidates);
        track(candidates, target, 0, track, trackSum, res);
        return res;
    }

    private void track(int[] candidates, int target, int start, LinkedList<Integer> track, int trackSum, List<List<Integer>> res) {
        // base case 1
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        // base case 2
        if (trackSum > target) return;
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            track.addLast(candidates[i]); trackSum += candidates[i];
            track(candidates, target, i + 1, track, trackSum, res);
            track.removeLast(); trackSum -= candidates[i];
        }
    }
}
