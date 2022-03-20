import java.util.HashSet;
import java.util.Set;

/**
 * @className: ContainsNearbyDuplicate
 * @description: 219. 存在重复元素 II
 * @author: Carl Tong
 * @date: 2022/2/16 16:29
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 用来保存窗口中的元素
        Set<Integer> cache = new HashSet<>();
        int start = 0, end = 0;
        while (end < nums.length) {
            if (cache.contains(nums[end])) return true;
            cache.add(nums[end]);
            if (end - start == k) {
                cache.remove(nums[start]);
                start++;
            }
            end++;
        }
        return false;
    }
}
