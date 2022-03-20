import java.util.Arrays;
import java.util.Scanner;

/**
 * @className: Meituan
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/12 16:05
 */
public class Meituan {

    static class TestOne {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (isLuckyNum(num)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }

        public static boolean isLuckyNum(int num) {
            if (num % 11 == 0) return true;
            int cur = num, count = 0;
            while (cur != 0) {
                if (cur % 10 == 1) count++;
                cur /= 10;
                if (count > 1) return true;
            }
            return false;
        }
    }

    static class TestTwo {
        static int res = 0;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            subSeq(nums, 0, 0);
            System.out.println(res - 1);
        }

        private static void subSeq(int[] nums, int cur, int value) {
            int curValue = value;
            if (value > 0) res += 1;
            if (cur == nums.length ) return;
            if (cur == 0) curValue = 1;
            for (int i = cur; i < nums.length; i++) {
                curValue *= nums[i];
                subSeq(nums, i + 1, curValue);
                curValue /= nums[i];
            }
        }

    }

    static class TestThree {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] comsumers = new int[n][2];
            for (int i = 0; i < n; i++) {
                comsumers[i][0] = sc.nextInt();
                comsumers[i][1] = sc.nextInt();
            }
            System.out.println(maxComsumer(comsumers, m));
        }

        private static int maxComsumer(int[][] consumers, int m) {
            boolean[] deal = new boolean[m + 1];
            Arrays.fill(deal, true);
            return dfs(consumers, deal, 0, 0);
        }

        private static int dfs(int[][] consumers, boolean[] deal, int cur, int count) {
            int res = count;
            if (cur == consumers.length) return res;
            for (int i = cur; i < consumers.length; i++) {
                int[] consumer = consumers[i];
                int mealOne = consumer[0], mealTwo = consumer[1];
                if (!(deal[mealOne] && deal[mealTwo])) continue;
                deal[mealOne] = false; deal[mealTwo] = false;
                res = Math.max(dfs(consumers, deal, i + 1, count + 1), res);
                deal[mealOne] = true; deal[mealTwo] = true;
            }
            return res;
        }
    }

    static class TestFour {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), m = sc.nextInt();
            int[] boom = new int[m];
            for (int i = 0; i < m; i++) {
                boom[i] = sc.nextInt();
            }
            System.out.println(minimum(n, boom));
        }

        private static int minimum(int room, int[] boom) {
            int[][] dp = new int[room][boom.length + 1];
            for (int i = 0; i < room; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < boom.length; i++) {
                for (int j = 0; j < i; j++) {
                    for (int k = 0; k < room; k++) {
                        dp[k][j] = Math.min(dp[k][j], dp[boom[i]][j] + 1);
                    }
                }
            }
            return dp[room - 1][boom.length];
        }
    }
}
