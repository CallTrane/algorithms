package 岛屿问题;

/**
 * @className: NumEnclaves
 * @description: 1020. 飞地的数量
 * @author: Carl Tong
 * @date: 2022/5/18 19:46
 */
public class NumEnclaves {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 把边界上的陆地处理
        for (int i = 0; i < m; i++) {
            // 处理左边
            dfs(grid, i, 0);
            // 处理右边
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            // 处理上边
            dfs(grid, 0, i);
            // 处理下边
            dfs(grid, m - 1, i);
        }
        int ret = 0;
        // 开始计算内部陆地
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) ret++;
            }
        }
        return ret;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int[][] grid, int row, int column) {
        // 下标越界
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return;
        // 已经是海了
        if (grid[row][column] == 0) return;
        // 淹没本地
        grid[row][column] = 0;
        // 继续发散淹没
        for (int[] dir : dirs) dfs(grid, row + dir[0], column + dir[1]);
    }
}
