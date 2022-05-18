package 岛屿问题;

/**
 * @className: CountSubIslands
 * @description: 1905. 统计子岛屿
 * @author: Carl Tong
 * @date: 2022/5/18 20:18
 */
public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        // 如果grid2中的岛屿，不在grid1中话，直接淹没
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) dfs(grid2, i, j);
            }
        }
        // 计算grid2中剩余岛屿数
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    // 计算
                    ret++;
                    // 淹没
                    dfs(grid2, i, j);
                }
            }
        }
        return ret;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 淹没 (row, column) 相邻陆地
    private void dfs(int[][] grid, int row, int column) {
        // 下标越界
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return;
        // 如果已经是海了
        if (grid[row][column] == 0) return;
        // 淹没本地及相邻
        grid[row][column] = 0;
        for (int[] dir : dirs) dfs(grid, row + dir[0], column + dir[1]);
    }
}
