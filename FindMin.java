/**
 * @className: FindMin
 * @description: 153. 寻找旋转排序数组中的最小值
 * @author: Carl Tong
 * @date: 2022/2/9 16:17
 */
public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // 因为元素都不相同，所以三者必定会出现一个元素是最大的，判断边界即可
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
