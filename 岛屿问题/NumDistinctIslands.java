package 岛屿问题;

import java.util.HashSet;
import java.util.Set;

/**
 * @className: NumDistinctIslands
 * @description: 694. 不同的岛屿数量
 * @author: Carl Tong
 * @date: 2022/5/18 21:03
 */
public class NumDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        // 记录不同的岛屿
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 用方向记录岛屿形状（初始方向随意填写）
                    dfs(grid, i, j, 0, builder);
                    // 清空数据，用于记录下一个岛屿
                    builder.delete(0, builder.length());
                }
            }
        }
        return set.size();
    }

    // 第一个数字代表x坐标的变化，第二个数字代表y坐标变化，第三个数字代表方向值
    private int[][] dirs = new int[][]{{0, 1, 1}, {0, -1, 2}, {1, 0, 3}, {-1, 0, 4}};

    // 序列化遍历，生成这串数字进行比较，就可以计算到底有多少个不同的岛屿
    private void dfs(int[][] grid, int row, int column, int dir, StringBuilder builder) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return;
        if (grid[row][column] == 0) return;
        // 前序遍历位置：进入 (row, column)
        grid[row][column] = 0;
        builder.append(dir).append(",");
        for (int[] direction : dirs) dfs(grid, row + direction[0], column + direction[1], direction[2], builder);
        // 后序遍历位置：离开 (row, column) （-dir代表撤销）
        builder.append(-dir).append(",");
    }
}
