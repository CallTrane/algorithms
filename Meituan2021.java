import java.util.*;
/**
 * @className: Meituan2021
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/8 1:42
 */
public class Meituan2021 {

    // meituan-001. 小美的用户名
    static class Meituan001 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                System.out.println(valid(str));
            }
        }
        private static String valid(String str) {
            char first = str.charAt(0);
            if (!(first >= 'A' && first <= 'Z') && !(first >= 'a' && first <= 'z')) return "Wrong";
            int numCount = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) continue;
                else if (c >= '0' && c <= '9') {
                    numCount++;
                    continue;
                } else return "Wrong";
            }
            return numCount > 0 ? "Accept" : "Wrong";
        }
    }

    // meituan-002. 小美的仓库整理
    static class Meituan002 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt() - 1, left = cur - 1, right = cur + 1;
                w[cur] = 0;
                int leftCount = 0, rightCount = 0;
                while (left >= 0) {
                    leftCount += w[left];
                    left--;
                }
                while (right < n) {
                    rightCount += w[right];
                    right++;
                }
                System.out.println(Math.max(leftCount, rightCount));
            }
        }
    }

}
