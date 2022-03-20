import java.util.Scanner;

/**
 * @className: Jibite
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/19 18:32
 */
public class Jibite {
    // 1 2 3 4 5 6 7 8    ||     2
    static class TestOne {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), k = sc.nextInt();
            boolean win = false;
            int start = 1;
            while (start != k) start++;
            int end = start, preEnd = 1;
            while (end <= n) {
                while (end - start + 1 != k) end++;
                if (end <= n) win = !win;
                else if (n - preEnd == k) win = !win;
                start = end + k;
                preEnd = end;
                end = start;
            }
            if (win) System.out.println("G win");
            else System.out.println("T win");
        }
    }

    static class TestTwo {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.println(getCount(map));
        }

        private static int getCount(int[][] map) {
            int n = map.length, m = map[0].length;
            int[][][] dp = new int[n][m][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        if (i > 0) dp[i][j][0] += (dp[i - 1][j][0] + dp[i - 1][j][1]);
                        if (j > 0) dp[i][j][0] += (dp[i][j - 1][0] + dp[i][j - 1][1]);
                    }
                    if (i == 0 && j == 0) dp[i][j][1] = 1;
                    if (i > 0) {
                        dp[i][j][1] += (dp[i - 1][j][0] % 987654321 + 1);
                        dp[i][j][0] += (dp[i - 1][j][1] % 987654321 + 1);
                    }
                    if (j > 0) {
                        dp[i][j][1] += (dp[i][j - 1][0] % 987654321 + 1);
                        dp[i][j][0] += (dp[i][j - 1][1] % 987654321 + 1);
                    }
                }
            }
            return dp[n - 1][m - 1][0] + dp[n - 1][m - 1][1];
        }
    }
}
