/**
 * @className: LargestTriangleArea
 * @description: 812. 最大三角形面积
 * @author: Carl Tong
 * @date: 2022/5/15 0:04
 */
public class LargestTriangleArea {
    // 线性代数 or 高等数学
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ret = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                for (int k = j + 1; k < n; k++) {
                    int x3 = points[k][0], y3 = points[k][1];
                    ret = Math.max(ret, triangleArea(x1, y1, x2, y2, x3, y3));
                }
            }
        }
        return ret;
    }

    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        // 行列式
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}
