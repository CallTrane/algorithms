import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: Subsets
 * @description: 78. 子集
 * @author: Carl Tong
 * @date: 2022/5/14 11:40
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        track(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private void track(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> res) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            track(nums, i + 1, track, res);
            track.removeLast();
        }
    }
}
