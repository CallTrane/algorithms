import java.util.*;

/**
 * @className: SiMaiTe
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/2/10 20:38
 */
public class SiMaiTe {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int left = 1;
        int right = n;
        while (left < right) {
            while (left + right != m) --right;
            System.out.println(left + " " + right);
            ++left;
            ++right;
        }
        if (left == right && left + right == m) System.out.print(left + " " + right);
    }*/


    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        if (N > 1) {
            ++ans;
            int cur = 1, tmp = 1;
            if (N - cur > 0) {
                ans += N;
                cur = 2;
                for (int i = N - cur + 1; i <= N; i++) {
                    tmp *= i;
                }
                ans += (tmp + 1) / 2;
            }
        }
        System.out.println(ans);
    }*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = -1;
        if (n > 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            if (n >= k && k > 0) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int num : arr) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                for (int count : map.values()) {
                    if (count >= k) ++ans;
                }
            }
        }
        System.out.println(ans);
    }*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        recur(result, 0, chars, new StringBuilder());
        result.stream().sorted().forEach(System.out::println);
    }

    public static void recur(List<String> result, int layer, char[] origin, StringBuilder builder) {
        if (layer == origin.length) {
            result.add(builder.toString());
            return;
        }
        for (int j = 0; j < origin.length; j++) {
            if (origin[j] == '?') {
                continue;
            } else {
                builder.append(origin[j]);
                origin[j] = '?';
                recur(result, layer + 1, origin, builder);
                origin[j] = builder.charAt(builder.length() - 1);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }*/

    public static void main(String[] args) {

    }

    interface Subject {
        void display();
    }

    class RealSubject implements Subject{
        @Override
        public void display() {
            System.out.println("真实主题类");
        }
    }

    class Proxy {
        public final RealSubject realSubject = new RealSubject();

        public void display() {
            realSubject.display();
        }

        public void packageProduct() {

        }

        public void incrPrice() {

        }
    }

}

