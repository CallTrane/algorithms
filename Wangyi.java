import java.util.*;

/**
 * @className: Wangyi
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/5 15:01
 */
public class Wangyi {

    class Union {
        int[] nodes;

        public Union(int n) {
            nodes = new int[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = i;
            }
        }

        public void union(int u, int v) {
            int uNode = findNode(u);
            int vNode = findNode(v);
            nodes[uNode] = vNode;
        }

        public int findNode(int i) {
            int value = i;
            while (value != nodes[value]) {
                value = nodes[value];
            }
            while (nodes[i] != i) {
                int tmp = nodes[i];
                nodes[i] = value;
                i = tmp;
            }
            return value;
        }

        public boolean isConnected(int start, int end) {
            return findNode(start) == findNode(end);
        }
    }

    public boolean validPath(int n, ArrayList<ArrayList<Integer>> sides, int start, int end) {
        Union union = new Union(n);
        for (ArrayList<Integer> side : sides) {
            union.union(side.get(0), side.get(1));
        }
        return union.isConnected(start, end);
    }

    public boolean compute24(int[] inputNumbers) {
        List<Integer> res = new ArrayList<>(3);
        for (int num : inputNumbers) {
            res.add(num);
        }
        return recur(res);
    }

    private boolean recur(List<Integer> nums) {
        if (nums.size() == 1) return nums.get(0) == 24;
        boolean res = false;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Integer> cur = new ArrayList<>(nums);
                int b = cur.remove(j), a = cur.remove(i);
                cur.add(a + b);
                res = res || recur(cur);
                cur.remove(cur.size() - 1);
                cur.add(a - b);
                res = res || recur(cur);
                cur.remove(cur.size() - 1);
                cur.add(b - a);
                res = res || recur(cur);
                cur.remove(cur.size() - 1);
                cur.add(a * b);
                res = res || recur(cur);
                cur.remove(cur.size() - 1);
                if (b != 0) {
                    cur.add(a / b);
                    res = res || recur(cur);
                    cur.remove(cur.size() - 1);
                }
                if (a != 0) {
                    cur.add(b / a);
                    res = res || recur(cur);
                    cur.remove(cur.size() - 1);
                }
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt(), K = sc.nextInt();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), value = sc.nextInt();
            matrix[x - 1][y - 1] = value;
        }
        System.out.print(maxValue(matrix));
    }

    private static int maxValue(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length, res = 0;
        // [step][x][y]
        int[][][] dp = new int[M + N][M + 1][N + 1];
        for (int k = 2; k < M + N; k++) {
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j && k >= i && k >= j) {
                        dp[k][i][j] = Math.max(Math.max(dp[k - 1][i - 1][j], dp[k - 1][i][j - 1]),
                                Math.max(dp[k - 1][i - 1][j - 1], dp[k - 1][i][j])) + matrix[i][k - i] + matrix[j][k - j];
                    }
                }
            }
        }
        return dp[M + N - 1][M - 1][N - 1];
    }
}
