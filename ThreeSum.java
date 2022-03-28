import java.util.*;

/**
 * @className: ThreeSum
 * @description: 剑指 Offer II 007. 数组中和为 0 的三个数
 *               15. 数组中和为 0 的三个数
 * @author: Carl Tong
 * @date: 2022/3/29 2:42
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // 每次固定一个数字
        for (int cur = 0; cur < nums.length - 2; cur++) {
            // 跳过已经找过结果的数字
            if (cur > 0 && nums[cur] == nums[cur - 1]) continue;
            int left = cur + 1, right = nums.length - 1;
            // 用双指针遍历所有与该固定数字所有的可能答案
            while (left < right) {
                int sum = nums[cur] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[cur], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // 将左指针移动到下一个不重复数字
                    left++;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
