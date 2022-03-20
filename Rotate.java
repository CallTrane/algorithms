/**
 * @className: Rotate
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/16 11:12
 */
public class Rotate {
    /**
     * 线性代数 - 矩阵变换
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 镜像对称
        // 对每行进行变换
        for (int i = 0; i < matrix.length; i++) {
            // 该行的每一列
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 每行进行反转
        for (int[] row : matrix) {
            for (int i = 0, j = row.length - 1; i < j; i++, j--) {
                int tmp = row[i];
                row[i] = row[j];
                row[j] = tmp;
            }
        }
    }
}
