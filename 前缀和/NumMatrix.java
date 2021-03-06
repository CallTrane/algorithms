package 前缀和;

/**
 * @className: NumMatrix
 * @description: 304. 二维区域和检索 - 矩阵不可变
 * @author: Carl Tong
 * @date: 2022/4/26 9:24
 */
public class NumMatrix {

    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        preSum = new int[n + 1][m + 1];
        // 计算前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 跟(row2, col2)坐标有关的应该+1，覆盖到；跟(row1, col1)有关的不能+1，不然会缺少数据
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1] ;
    }
}
