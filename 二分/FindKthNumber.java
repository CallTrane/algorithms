package 二分;

/**
 * @className: FindKthNumber
 * @description: 668. 乘法表中第k小的数
 * @author: Carl Tong
 * @date: 2022/5/18 14:44
 */
public class FindKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 因为是在 [1, m * n] 范围内进行二分查找，二分查找过程中取得的值不一定在乘法表中。
            // 所以不能在 count = k 时直接返回结果，而应该继续进行二分查找，最终返回能满足 count = k 的最小 x 值
            if (getCount(m, n, mid) >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 找出比 mid 小的个数
    private int getCount(int m, int n, int mid) {
        int count = 0;
        // 不能从左上或者右下开始，因为不能确定（两侧都属于同一种单调），所以必须从左下或者右上开始（这里是左下）
        for (int i = 1; i <= n; i++) {
            // 如果 mid 大于该列最大值（最底），则为该列所有个数，否则为 mid / i （因为 i * m = mid）
            count += Math.min(m, mid / i);
        }
        return count;
    }
}
