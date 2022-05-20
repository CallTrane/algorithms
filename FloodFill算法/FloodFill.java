package FloodFill算法;

/**
 * @className: FloodFill
 * @description: 733. 图像渲染
 *               面试题 08.10. 颜色填充
 * @author: Carl Tong
 * @date: 2022/5/20 11:28
 */
public class FloodFill {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // ================ 区域填充 =======================
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        areaFill(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void areaFill(int[][] image, int x, int y, int oldColor, int newColor) {
        // 越界
        if (!inArea(image, x, y)) return;
        // 不是同种需要覆盖的颜色
        if (image[x][y] != oldColor) return;
        // 如果已经被修改过了（看数值范围，一般用visited数组做标记）
        if (image[x][y] == -1) return;
        // 做选择：标记，避免重复
        image[x][y] = -1;
        // 发散遍历
        for (int[] dir : dirs) areaFill(image, x + dir[0], y + dir[1], oldColor, newColor);
        // 撤销选择：将标记换成需要更改的新颜色
        image[x][y] = newColor;
    }

    // ================ 自动魔棒工具 ====================
    // 1、不能保证都是相同颜色，毕竟是像素点，可能存在肉眼无法分辨的深浅差异，而我们希望能够忽略细微的颜色差异
    //      解决：用一个阈值threshold，在阈值范围内波动的颜色都视为 oldColor
    // 2、这里是想找到 oldColor 区域的边界，可以抽象成「边界填充」
    //      解决：oldColor坐标四面一定都是oldColor。而边界上的坐标，至少有一个方向不是oldColor

    // 注意，这里的if判断顺序不能打乱
    private int boundaryFill(int[][] image, boolean[][] visited, int x, int y, int oldColor, int newColor, int threshold) {
        // 1、必须先判断边界（防止下标越界）
        if (!inArea(image, x, y)) return 0;
        // 2、接着判断是否已经访问过（防止边界坐标换颜色后，如果先判断颜色，则会导致内部区域判断错误）
        if (visited[x][y]) return 1;
        // 3、最后再判断颜色是否在范围内
        if (Math.abs(image[x][y] - oldColor) > threshold) return 0;
        // 标记
        visited[x][y] = true;
        // 判断该点是否是边界（向四面发散遍历，如果是内部区域，则四面的回调都会返回1），如果是边界则需要上色
        int surround = 0;
        for (int[] dir : dirs) surround += boundaryFill(image, visited, x + dir[0], y + dir[1], oldColor, newColor, threshold);
        // 如果不为4，说明是边界，需要换颜色
        if (surround < 4) image[x][y] = newColor;
        // 该点为上色点，需要给回调返回1
        return 1;
    }

    private boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }
}
