package 岛屿问题;

/**
 * @className: NumIslands
 * @description: 200. 岛屿数量
 * @author: Carl Tong
 * @date: 2022/5/18 17:12
 */
public class NumIslands {
    // 二维矩阵本质上是一幅「图」，所以遍历的过程中需要一个 visited 布尔数组防止走回头路
    public int numIslands(char[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果发现岛屿
                if (grid[i][j] == '1') {
                    // +1
                    ret++;
                    // 将该岛屿淹没（避免维护 visited数组）
                    dfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    // 方向数组
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(char[][] grid, int row, int column) {
        // 处理下标越界
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return;
        // 如果已经是海了
        if (grid[row][column] == '0') return;
        // 淹没该地
        grid[row][column] = '0';
        // 继续发散淹没
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], column + dir[1]);
        }
    }
}
