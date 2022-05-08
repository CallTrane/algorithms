import java.util.*;

/**
 * @className: FindDuplicates
 * @description: 442. 数组中重复的数据
 * @author: Carl Tong
 * @date: 2022/5/8 22:04
 */
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 数组中的元素对应 0 ~ n-1，每个元素只会出现一次或两次，一次的话则是一一对应，那么把访问过的元素置为负数，代表访问过
        for (int i = 0; i < nums.length; i++) {
            // 先把元素值置为正的，再-1，对应数组下标，防止越界
            int val = Math.abs(nums[i]) - 1;
            // 如果还没被访问过
            if (nums[val] > 0) nums[val] = -nums[val];
            // 否则，说明已经被访问过，放入答案（需要 +1 回来，因为上面为了对应数组下标 -1 了）
            else res.add(val + 1);
        }
        return res;
    }
}
