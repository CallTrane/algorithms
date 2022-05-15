package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: 回溯.Subsets
 * @description: 78. 子集
 * @author: Carl Tong
 * @date: 2022/5/14 11:40
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 记录回溯算法的递归路径
        LinkedList<Integer> track = new LinkedList<>();
        track(nums, 0, track, res);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    private void track(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> res) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // i 通过 start 参数控制树枝的遍历，避免产生重复的子集
            track(nums, i + 1, track, res);
            // 撤销选择
            track.removeLast();
        }
    }
}
