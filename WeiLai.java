import java.util.*;

/**
 * @className: WeiLai
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/4 19:23
 */
public class WeiLai {
    public boolean solve(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() == 0 || B.length() == 0) return true;
        int[] s = new int[A.length() + 1];
        Arrays.fill(s, 1);
        for (int left = -1, right = 0; right < A.length(); right++) {
            while (left >= 0 && B.charAt(left) != B.charAt(right)) {
                left -= s[left];
            }
            s[right + 1] = right - left;
            left++;
        }
        int length = 0;
        for (char c : (A + A).toCharArray()) {
            while (length >= 0 && B.charAt(length) != c) {
                length -= s[length];
            }
            if (++length == A.length()) return true;
        }
        return false;
    }

    /*public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ans++;
            }
            res.add(ans);
        }
        for (int ans : res) {
            System.out.println(ans);
        }
    }*/

    public static int firstMissingPositive (int[] A) {
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1]) break;
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(search(matrix));
    }

    public static int search(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + matrix[i][j]);
                if (j - 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + matrix[i][j]);
            }
        }
        return dp[n - 1][m - 1];
    }

}
