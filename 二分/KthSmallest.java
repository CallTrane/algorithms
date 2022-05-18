package 二分;

/**
 * @className: KthSmallest
 * @description: 378. 有序矩阵中第 K 小的元素
 * @author: Carl Tong
 * @date: 2022/5/18 15:26
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (getCount(matrix, mid) >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 计算矩阵中小于等于 mid 的个数
    private int getCount(int[][] matrix, int mid) {
        int n = matrix.length, count = 0;
        // 从左下角开始
        for (int i = n - 1, j = 0; i >= 0 && j < n;) {
            if (matrix[i][j] <= mid) {
                // 索引是 -1 的，计算个数要补上+1
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
