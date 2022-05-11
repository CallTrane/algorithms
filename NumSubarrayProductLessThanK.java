/**
 * @className: NumSubarrayProductLessThanK
 * @description: 剑指 Offer II 009. 乘积小于 K 的子数组
 *               713. 乘积小于 K 的子数组
 * @author: Carl Tong
 * @date: 2022/4/24 14:56
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, product = 1;
        for (int left = 0, right = 0; right < nums.length; right++) {
            product *= nums[right];
            // 窗口右移
            while (left < right && product >= k) product /= nums[left++];
            // 因为是要连续的子数组，且以right为基准的（不会重复，且刚好每一个都遍历过）。
            // 每确定一个新的right，就会有新的 right - left + 1 个子数组
            // 例如 ABC < k ，新增X。 若 ABCX < k ，则以X为基准新增子数组 X，CX，BCX，ABCX不会重复
            if (left <= right && product < k) res += right - left + 1;
        }
        return res;
    }
}
