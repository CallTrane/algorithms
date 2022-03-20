import java.util.*;

/**
 * @className: Xiecheng
 * @description: TODO
 * @author: carl
 * @date: 2021/9/9 19:04
 */
public class Xiecheng {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String pwd = "";
        Stack<String> stack = new Stack();

        for (int i = 0; i <= n; i++) {
            String command = sc.nextLine();
            if (command.equals("cd ..")) {
                pwd = pwd.replace(stack.pop(), "");
            } else if (command.contains("cd")) {
                String current = "\\" + command.substring(3);
                stack.push(current);
                pwd += current;
            } else if (command.equals("pwd")){
                if (stack.size() == 0) {
                    System.out.println("\\");
                    continue;
                }
                System.out.println(pwd);
            }
        }
    }*/

    /*static int[] nums;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        nums = new int[size];
        k = sc.nextInt();
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        int result = cutArrays(nums, k);
        System.out.println(result);
    }

    static int cutArrays(int[] nums, int k) {
        if (nums.length == k) {
            return 0;
        }
        *//**
         * dp[i][j]
         * i：第几个位置
         * j：割 / 不割
         *//*
        int length = nums.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            dp[i][0]
        }
    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int count = sc.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        int[] score = new int[count];
        for (int i = 0; i < count; i++) {

        }

        //0 <=x < 差值(2)

        //4 6 || %4 || 0 1 2 3
    }
}
