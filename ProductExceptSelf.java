/**
 * @className: ProductExceptSelf
 * @description: 238. 除自身以外数组的乘积
 * @author: Carl Tong
 * @date: 2022/2/15 14:23
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        // 用于保存元素左边的所有成绩
        int pre = 1;
        // 从左往右扫，先计算当前元素左边的乘积
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre *= nums[i];
        }
        pre = 1;
        // 从右往左扫再扫一遍，计算当前元素右边边的乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            // 因为是要 值 = 左边乘积 * 右边乘积
            res[i] *= pre;
            pre *= nums[i];
        }
        return res;
    }
}
