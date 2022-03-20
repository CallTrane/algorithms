/**
 * @className: FindBall
 * @description: 1706. 球会落何处
 * @author: Carl Tong
 * @date: 2022/2/24 11:06
 */
public class FindBall {
    public int[] findBall(int[][] grid) {
        // n个球
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int depth = 0, pos = i;
            while (depth < m) {
                int aside = pos + grid[depth][pos];
                if (aside < 0 || aside >= n || grid[depth][aside] == -grid[depth][pos]) {
                    pos = -1;
                    break;
                }
                pos = aside;
                depth++;
            }
            res[i] = pos;
        }
        return res;
    }
}

class Test2 {
    public static void main(String[] args) {
        new FindBall().findBall(new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}});
    }
}