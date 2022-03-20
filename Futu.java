import java.util.*;

/**
 * @className: Futu
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/5 17:09
 */
public class Futu {

    /*static int a, b, c, d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); int[] people = new int[N];
        a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt(); d = sc.nextInt();
        people[0] = d;
        for (int i = 1; i < N; i++) {
            people[i] = calculate(people[i - 1]);
        }
        Arrays.sort(people);
        int first = 0, second = 0;
        boolean take = false;
        for (int i = N - 1; i >= 0; i--) {
            if (!take) {
                first += people[i];
                take = true;
            } else {
                second += people[i];
                take = false;
            }
        }
        System.out.print(first - second);
    }

    public static int calculate(int n) {
        return (a * n * n + b * n + c) % 1000000;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print(boom(a, k));
    }

    public static int boom(int[] a, int k) {
        if (a.length < 2) return 0;
        Arrays.sort(a);
        int left = 0, right = a.length - 1, res = 0;
        while (left < right) {
            while (left < right && a[left] + a[right] < k) left++;
            while (left < right && a[left] + a[right] > k) right--;
            // 判断两边谁少
            while (left < right && a[left] + a[right] == k) {
                left++; right--; res++;
            }
        }
        return res;
    }
}
