package 岛屿问题;

/**
 * @className: MaxAreaOfIsland
 * @description: 695. 岛屿的最大面积
 * @author: Carl Tong
 * @date: 2022/5/18 20:08
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) ret = Math.max(ret, dfs(grid, i, j));
            }
        }
        return ret;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 淹没与 (row, column) 相邻的陆地，并返回淹没的面积
    private int dfs(int[][] grid, int row, int column) {
        // 下标越界
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return 0;
        // 已经是海了
        if (grid[row][column] == 0) return 0;
        // 淹没该地
        grid[row][column] = 0;
        // 继续发散淹没，返回面积 = 本地 1 + 其他相邻陆地面积
        int area = 1;
        for (int[] dir : dirs) area += dfs(grid, row + dir[0], column + dir[1]);
        return area;
    }
}
