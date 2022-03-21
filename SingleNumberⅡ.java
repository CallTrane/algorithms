import java.util.HashMap;
import java.util.Map;

/**
 * @className: SingleNumberⅡ
 * @description: 剑指 Offer II 004. 只出现一次的数字
 *               137. 只出现一次的数字 II
 * @author: carl
 * @date: 2021/10/12 0:52
 */
public class SingleNumberⅡ {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) res = entry.getKey();
        }
        return res;
    }

    // 需要有一定的数字电路设计的基础
    // 时间复杂度O(n) 空间复杂度O(1)
    /*public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }*/
}
