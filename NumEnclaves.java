/**
 * @className: NumEnclaves
 * @description: 1020. 飞地的数量
 * @author: Carl Tong
 * @date: 2022/2/12 21:41
 */
public class NumEnclaves {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 用来标记可以访问到边界的
        boolean[][] visited = new boolean[m][n];
        // 从最外的四条边开始深度遍历，标记所有能访问到的
        for (int i = 0; i < m; i++) {
            dfs(visited, grid, i, 0);
            dfs(visited, grid, i, n - 1);
        }
        for (int i = 1; i < n - 1; i++) {
            dfs(visited, grid, 0, i);
            dfs(visited, grid, m - 1, i);
        }
        // 开始计算
        int ans = 0;
        // 不需要计算四周的
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) ++ans;
            }
        }
        return ans;
    }

    private void dfs(boolean[][] visited, int[][] grid, int x, int y) {
        // 如果长度越界、该位置为海、或是已经被标记过可以访问的，则终止遍历
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        dfs(visited, grid, x - 1, y);
        dfs(visited, grid, x + 1, y);
        dfs(visited, grid, x, y - 1);
        dfs(visited, grid, x, y + 1);
    }
}
