/**
 * @className: RemoveDuplicates
 * @description: 26. 删除有序数组中的重复项
 * @author: Carl Tong
 * @date: 2022/3/17 17:43
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        // 长度是 索引+1
        return slow + 1;
    }
}
