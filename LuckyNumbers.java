import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: LuckyNumbers
 * @description: 1380. 矩阵中的幸运数（矩阵中的所有元素都是不同的）
 * @author: Carl Tong
 * @date: 2022/2/15 1:18
 */
public class LuckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // m为行数，n为列数
        int m = matrix.length, n = matrix[0].length;
        int[] max = new int[n];
        int[] min = new int[m];
        Arrays.fill(min, Integer.MAX_VALUE);
        // 预存数据
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max[j] = Math.max(max[j], matrix[i][j]);
                min[i] = Math.min(min[i], matrix[i][j]);
            }
        }
        // 交点即是幸运数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max[j] == min[i]) res.add(max[j]);
            }
        }
        return res;
    }
}
