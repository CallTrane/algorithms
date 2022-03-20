/**
 * @className: MatrixPath
 * @description: 剑指 Offer 12. 矩阵中的路径
 * @author: carl
 * @date: 2021/8/16 15:55
 */
public class MatrixPath {
    public boolean exist(char[][] matrix, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, char[] words, int i, int j, int k) {
        //如果不相等或者超过边界
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        //如果相等，把该点标记
        matrix[i][j] = '\0';
        //接着继续查找
        boolean result = dfs(matrix, words, i+1, j, k+1) || dfs(matrix, words, i-1, j, k+1) ||
                dfs(matrix, words, i, j+1, k+1) || dfs(matrix, words, i, j-1, k+1);
        //最后还原矩阵，让其他尝试
        matrix[i][j] = words[k];
        return result;
    }
}
