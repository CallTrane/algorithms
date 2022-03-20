import java.util.HashMap;
import java.util.Map;

/**
 * @className: countKDifference
 * @description: 2006. 差的绝对值为 K 的数对数目
 * @author: Carl Tong
 * @date: 2022/2/9 14:54
 */
public class CountKDifference {

    /*public int countKDifference(int[] nums, int k) {
        if (nums.length <= 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - nums[j] == k || nums[j] - nums[i] == k)   res++;
            }
        }
        return res;
    }*/

    /**
     * 空间换时间
     *
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        // {值:出现的次数}    边遍历边记录某个数出现次数
        Map<Integer, Integer> cache = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (cache.containsKey(num - k)) res += cache.get(num - k);
            if (cache.containsKey(num + k)) res += cache.get(num + k);
            cache.put(num, cache.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
