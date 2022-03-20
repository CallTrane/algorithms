/**
 * @className: SpiralOrderII
 * @description: 59. 螺旋矩阵 II
 * @author: Carl Tong
 * @date: 2022/3/16 12:37
 */
public class SpiralOrderII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1, num = 1;
        while (num <= n * n) {
            // 上列 : 左到右
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    matrix[up][i] = num++;
                }
                up++;
            }
            // 右列 : 上到下
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }
            // 下列 : 右到左
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = num++;
                }
                down--;
            }
            // 左列 : 下到上
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }
}
