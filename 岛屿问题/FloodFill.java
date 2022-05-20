package 岛屿问题;

/**
 * @className: FloodFill
 * @description: 面试题 08.10. 颜色填充
 * @author: Carl Tong
 * @date: 2022/5/20 11:28
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        fill(image, sr, sc, oldColor, newColor);
        return image;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void fill(int[][] image, int x, int y, int oldColor, int newColor) {
        // 越界
        if (!inArea(image, x, y)) return;
        // 不是同种需要覆盖的颜色
        if (image[x][y] != oldColor) return;
        // 如果已经被修改过了
        if (image[x][y] == -1) return;
        // 做选择：标记，避免重复
        image[x][y] = -1;
        // 发散遍历
        for (int[] dir : dirs) fill(image, x + dir[0], y + dir[1], oldColor, newColor);
        // 撤销选择：将标记换成需要更改的新颜色
        image[x][y] = newColor;
    }

    private boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }
}
