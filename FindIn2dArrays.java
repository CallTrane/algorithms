import org.junit.Test;

/**
 * 04二位数组中查找
 *      每一行都按照从左到右递增，每一列都按照从上到下递增
 *
 * 思路：首先选取二维数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束；
 *      如果该数字大于要查找的数字，则剔除这个数字所在的列；
 *      如果该数字小于要查找的数字，则剔除这个数字所在的行。
 */
public class FindIn2dArrays {

    public boolean find(int matrix[][], int number) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (matrix != null && rows > 0 && columns > 0) {
            //从二维数组的右上角开始找
            int row = 0;
            int column = columns - 1;
            //行是一直加的，列是一直减的
            while (row < rows && column >= 0) {
                if (matrix[row][column] == number) {
                    return true;
                } else if (matrix[row][column] > number) {
                    --column;
                } else {
                    ++row;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(find(matrix, 3));
        System.out.println(find(matrix, 10));
    }
}
