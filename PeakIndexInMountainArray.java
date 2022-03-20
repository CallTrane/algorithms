/**
 * @className: PeakIndexInMountainArray
 * @description: 剑指 Offer II 069. 山峰数组的顶部
 * @author: Carl Tong
 * @date: 2022/3/11 15:08
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left < right) {
            int mid = (left + right) >> 1;
            // 找到第一个左大于右的
            if (arr[mid] > arr[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
