import java.util.LinkedList;
import java.util.List;

/**
 * @className: SpiralOrder
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 * @author: carl
 * @date: 2021/9/9 12:30
 */
public class SpiralOrder {

    /*public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        int index = 0;
        int[] result = new int[(right+1)*(down+1)];
        while (true) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[up][i];
            }
            //判断下一次会不会越界
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                result[index++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result[index++] = matrix[down][i];
            }
            if (up > --down) {
                break;
            }
            for (int i = down; i >= up; i--) {
                result[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }*/

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, up = 0, down = m - 1;
        List<Integer> res = new LinkedList<>();
        while (res.size() < m * n) {
            // 上列 : 左 -> 右
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[up][i]);
                }
                up++;
            }
            // 右列 : 上 -> 下
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            // 下列 : 右 -> 左
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
            }
            // 左列 : 下 -> 上
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
