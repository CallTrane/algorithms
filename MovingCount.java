/**
 * @className: MovingCount
 * @description: 剑指 Offer 13. 机器人的运动范围
 * @author: carl
 * @date: 2021/8/17 0:56
 */

//根据可达解的结构和连通性，易推出机器人可 仅通过向右和向下移动，访问所有可达解 。
public class MovingCount {
    //矩阵
    int m, n;
    //记录矩阵某个位置是否被用过
    boolean[][] visited;

    //计算数位之和
    private int sum(int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }
        while (y != 0) {
            sum += y % 10;
            y = y / 10;
        }
        return sum;
    }

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        visited = new boolean[m][n];
        return dfs(0, 0, k);
    }

    private int dfs(int i, int j, int k) {
        //如果越界、已经被访问过、数位之和超过
        if (i >= m || j >= n || visited[i][j] == true || sum(i, j) > k) {
            return 0;
        }
        //标记已经被访问过
        visited[i][j] = true;
        return 1 + dfs(i+1, j, k) + dfs(i, j+1, k);
    }
}
