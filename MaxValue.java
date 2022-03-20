/**
 * @className: MaxValue
 * @description: 剑指 Offer 47. 礼物的最大价值
 * @author: carl
 * @date: 2021/9/4 2:51
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < column; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[row-1][column-1];
    }
}
