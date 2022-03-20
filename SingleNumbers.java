/**
 * @className: SingleNumbers
 * @description: 剑指 Offer 56 - I. 数组中数字出现的次数
 * @author: carl
 * @date: 2021/9/6 23:25
 */
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, z = 0, m = 1;
        for (int i : nums) {
            z ^= i;
        }
        // z为两个数字，异或到第一位不同的为1，然后根据这个位置进行分组
        while ((m & z) == 0) {
            m <<= 1;
        }
        for (int i : nums) {
            if ((i & m) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        return new int[]{x, y};
    }
}
