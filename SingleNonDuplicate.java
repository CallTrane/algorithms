/**
 * @className: SingleNonDuplicate
 * @description: 540. 有序数组中的单一元素
 * @author: Carl Tong
 * @date: 2022/2/14 20:05
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int index = 0, last = nums.length - 1, ans = nums[0];
        while (index < last) {
            if (nums[index] != nums[index + 1]) {
                ans = nums[index];
                break;
            }
            index += 2;
        }
        if (index == last) {
            ans = nums[last];
        }
        return ans;
    }
}
