package 岛屿问题;

/**
 * @className: ClosedIsland
 * @description: 1254. 统计封闭岛屿的数目
 * @author: Carl Tong
 * @date: 2022/5/18 19:21
 */
public class ClosedIsland {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 题目描述四周靠边的岛屿不算，先淹没
        for (int i = 0; i < m; i++) {
            // 淹没左边
            dfs(grid, i, 0);
            // 淹没右边
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            // 淹没上边
            dfs(grid, 0, i);
            // 淹没下边
            dfs(grid, m - 1, i);
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果发现岛屿
                if (grid[i][j] == 0) {
                    // 数量 + 1
                    ret++;
                    // 淹没该岛屿
                    dfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    // 方向数组
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int[][] grid, int row, int column) {
        // base case : 判断下标是否越界
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return;
        // base case : 是否已淹没
        if (grid[row][column] == 1) return;
        // 淹没该地
        grid[row][column] = 1;
        // 继续发散淹没
        for (int[] dir : dirs) dfs(grid, row + dir[0], column + dir[1]);
    }
}
