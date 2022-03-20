import org.junit.Test;

/**
 * 旋转矩阵
 */
public class RotateMatrix {
    public int[][] rotate(int matrix[][]) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row/2; i++) {
            for (int j = 0; j < (column+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-1-j][i];
                matrix[row-1-j][i] = matrix[row-1-i][column-1-j];
                matrix[row-1-i][column-1-j] = matrix[row-column+j][column-1-i];
                matrix[row-column+j][row-1-i] = temp;
            }
        }
        return matrix;
    }

    @Test
    public void test() {
        int matrix[][] = new int[][]{{1,2},{3,4}};
        int[][] result = rotate(matrix);
        for (int[] row : result) {
            for (int i : row) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
