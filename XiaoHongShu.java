import java.util.*;

/**
 * @className: XiaoHongShu
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/13 19:09
 */
public class XiaoHongShu {

    static class TestOne {
        // 0.83
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(maxCount(nums));
        }

        private static int maxCount(int[] nums) {
            int start = 0, n = nums.length;
            int oneCount = 0, zeroCount = 0, res = 0;
            while (start < n && nums[start] != 0) start++;
            for (int end = start; end < n; end++) {
                if (nums[end] == 1) oneCount++;
                else zeroCount++;
                if (zeroCount > oneCount) {
                    reverse(nums, start, end);
                    start = end + 1;
                    zeroCount = 0;
                    oneCount = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                res += nums[i];
            }
            return res;
        }

        private static void reverse(int[] nums, int start, int end) {
            for (int i = start; i <= end; i++) {
                if (nums[i] == 1) nums[i] = 0;
                else nums[i] = 1;
            }
        }
    }

    static class TestTwo {
        // 0.83
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
            boolean[][] map = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(map[i], true);
            }
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt(), y = sc.nextInt();
                map[x - 1][y - 1] = false;
            }
            System.out.println(getCount(map));
        }

        private static int getCount(boolean[][] map) {
            int m = map.length, n = map[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!map[i][j]) continue;
                    if (i == 0 && j == 0) dp[i][j] = 1;
                    if (i - 1 >= 0 && map[i - 1][j]) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % ((int) Math.pow(10, 9) + 7);
                    if (j - 1 >= 0 && map[i][j - 1]) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % ((int) Math.pow(10, 9) + 7);
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    static class TestThree {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), k = sc.nextInt();
            int[] value = new int[n];
            for (int i = 0; i < n; i++) {
                value[i] = sc.nextInt();
            }
            // 类似于直接把所有答案缓存，把时间复杂度将为O(1)
            int[][] cache = getDp(value);
            for (int i = 0; i < k; i++) {
                int a = sc.nextInt(), b = sc.nextInt();
                if (a <= b) System.out.println(cache[a][b]);
                else System.out.println(cache[b][a]);
            }
        }

        private static int[][] getDp(int[] value) {
            int n = value.length;
            int[][] dp = new int[n + 1][n + 1];
            for (int end = 1; end <= n; end++) {
                for (int start = 1; start < end; start++) {
                    int maximum = Integer.MIN_VALUE, minimum = Integer.MAX_VALUE;
                    for (int i = start; i <= end; i++) {
                        maximum = Math.max(maximum, value[i - 1]);
                        minimum = Math.min(minimum, value[i - 1]);
                    }
                    dp[start][end] = maximum - minimum;
                }
            }
            return dp;
        }

        private static int getResult(int[] value, int start, int end) {
            int maximum = Integer.MIN_VALUE, minimum = Integer.MAX_VALUE;
            for (int i = start; i <= end && i < value.length; i++) {
                maximum = Math.max(maximum, value[i]);
                minimum = Math.min(minimum, value[i]);
            }
            return maximum - minimum;
        }
    }

    static class FirstInterview {
        // 归并排序

        private int[] tmp;

        public void sort(int[] nums) {
            tmp = new int[nums.length - 1];
            sort(nums, 0, nums.length - 1);
        }

        private void sort(int[] nums, int left, int right) {
            if (left == right) return;
            int mid = left + (right - left) / 2;
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

        private void merge(int[] nums, int left, int mid, int right) {
            for (int i = left; i <= right; i++) {
                tmp[i] = nums[i];
            }
            int leftIndex = left, rightIndex = mid + 1;
            for (int i = left; i <= right; i++) {
                if (leftIndex == mid + 1) nums[i] = tmp[rightIndex++];
                else if (rightIndex == right + 1) nums[i] = tmp[leftIndex++];
                else if (tmp[leftIndex] > tmp[rightIndex]) nums[i] = tmp[rightIndex++];
                else nums[i] = tmp[leftIndex++];
            }
        }
    }
}
