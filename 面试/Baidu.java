package 面试;

import java.util.*;

public class Baidu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i;
        }
        int index = 0;
        for (int x = 0; x < Q; x++) {
            int result = 0;
            int count = sc.nextInt();
            while (nums[index] > 0) {
                result++;
                nums[index]--;
            }
            for (int i = index + 1; i < nums.length; i++) {
                if (count <= 0) {
                    break;
                }
                if (nums[index] == 0 && i == index+1) {
                    result += nums[i];
                    nums[i] = 0;
                } else {
                    while (nums[i-1]+1 < nums[i]) {
                        result++;
                        nums[i]--;
                    }
                }
                count--;
            }
            System.out.print(result+" ");
            index++;
        }
    }*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;
        for (int i = 1; i <= K; i++) {
            int temp = N * i;
            int a = temp / 10, b = temp % 10;
            while (a != 0) {
                b = b * 10 + a % 10;
                a = a / 10;
            }
            result = Math.max(result, b);
        }
        System.out.println(result);
    }*/
}


/*public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] times = new int[n];
    for (int i = 0; i < n; i++) {
        times[i] = sc.nextInt();
    }

    int angry = 0;
    for (int i = times.length - 1; i >= 0 && times[i] > k; i--) {
        angry++;
    }

    String result;
    if (angry == 0) {
        result = "0/1";
    } else {
        result = angry + "/" + times.length;
    }
    System.out.print(result);
}*/
/*public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String hit = sc.nextLine();
    int m = sc.nextInt();

    char[] chars = hit.toCharArray();
    List<String> result = new ArrayList();

    String tmp = sc.nextLine();
    for (int i = 0; i < m; i++) {

        tmp = sc.nextLine();
        char[] temp = tmp.toCharArray();

        int index = 0;
        while (index < temp.length) {
            if (chars[index] == 'X' && temp[index] == '1') {
                result.add("NO");
                break;
            }
            index++;
        }
        if (index == temp.length) {
            result.add("YES");
        }
    }

    for (String s : result) {
        System.out.println(s);
    }
}*/