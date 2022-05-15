package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: CombinationSum3
 * @description: 216. 组合总和 III
 * @author: Carl Tong
 * @date: 2022/5/15 11:40
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        // 记录回溯路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(k, n, 1, track, 0, ret);
        return ret;
    }

    private void backtrack(int count, int target, int start, LinkedList<Integer> track, int trackSum, List<List<Integer>> ret) {
        if (track.size() == count) {
            if (trackSum == target) ret.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) return;
        for (int i = start; i <= 9; i++) {
            // 做选择
            track.addLast(i); trackSum += i;
            // 回溯
            backtrack(count, target, i + 1, track, trackSum, ret);
            // 撤销选择
            track.removeLast(); trackSum -= i;
        }
    }
}
