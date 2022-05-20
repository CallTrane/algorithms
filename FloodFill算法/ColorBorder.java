package FloodFill算法;

import java.util.Arrays;

/**
 * @className: ColorBorder
 * @description: 1034. 边界着色
 * @author: Carl Tong
 * @date: 2022/5/20 17:07
 */
public class ColorBorder {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int oldColor = grid[row][col], m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        colorBorder(grid, visited, row, col, oldColor, color);
        return grid;
    }

    // 这里的 if 判断顺序不能改
    private int colorBorder(int[][] grid, boolean[][] visited, int x, int y, int oldColor, int newColor) {
        // 1、先判断是否越界
        if (!inArea(grid, x, y)) return 0;
        // 2、接着判断是否已经访问过（不能先判断颜色，避免边界坐标换颜色后，其他坐标先判断颜色，会导致判断内部区域错误）
        if (visited[x][y]) return 1;
        // 3、最后再判断颜色
        if (grid[x][y] != oldColor) return 0;
        // 标记
        visited[x][y] = true;
        // 发散遍历，判断该点是否是边界（向四面发散遍历，如果是内部区域，则四面的回调都会返回1）
        int surround = Arrays.stream(dirs).mapToInt(dir -> colorBorder(grid, visited, x + dir[0], y + dir[1], oldColor, newColor)).sum();
        // 如果小于4，则说明是边界，需要上色
        if (surround < 4) grid[x][y] = newColor;
        // 该点遍历完，需要给回调返回1
        return 1;
    }

    private boolean inArea(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
