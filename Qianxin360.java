import java.util.*;

/**
 * @className: Qianxin360
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/3/6 15:46
 */
public class Qianxin360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine(), s2 = sc.nextLine(), s3 = sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();
        List<String> list1 = getTable(s1), list2 = getTable(s2), list3 = getTable(s3);
        for (int i = 0; i < m; i++) {
            String ans = sc.nextLine();
            String[] s = ans.split(" ");
            boolean occur = false, res = true;
            for (int j = 0; j < s.length; j++) {
                if (j == 0 && !list1.contains(s[j])) {
                    res = false;
                    break;
                }
                if (list2.contains(s[j])) {
                    if (occur) {
                        res = false;
                        break;
                    } else {
                        occur = true;
                    }
                }
            }
            if (res) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static List<String> getTable(String s) {
        List<String> res = new ArrayList<>();
        String[] strings = s.split(" ");
        for (String s1 : strings) {
            res.add(s1);
        }
        return res;
    }

    class TestOne {
        public int minCheckDuration(ArrayList<Integer> goods) {
            if (goods.size() <= 1) return 0;
            if (goods.size() == 2) return Math.min(goods.get(0), goods.get(1));
            int[] dp = new int[goods.size() + 1];
            for (int i = 2; i <= goods.size(); i++) {
                dp[i] = Math.min(dp[i - 2] + goods.get(i - 2), dp[i - 1] + goods.get(i - 1));
            }
            return dp[goods.size()];
        }

    }

    class TestTwo {

        class TreeNode {
            int val;
            TreeNode left, right;
        }

        TreeNode wrongOne, wrongTwo, last;
        public TreeNode TreeRecover(TreeNode root) {
            if (root == null) return null;
            TreeRecover(root.left);
            if (last != null && last.val > root.val) {
                if (wrongOne == null) wrongOne = last;
                wrongTwo = last;
            }
            last = root;
            TreeRecover(root.right);
            // morris算法 空间复杂度O(1)
            /*if (root == null) return null;
            TreeNode left = null, right = null, pre = null, suc = null;
            while (root != null) {
                if (root.left != null) {
                    suc = root.left;
                    while (suc.right != null && suc.right != root) suc = suc.right;
                    if (suc.right == null) {
                        suc.right = root;
                        root = root.left;
                    } else {
                        if (pre != null && root.val < pre.val) {
                            right = root;
                            if (left == null) left = pre;
                        }
                        pre = root;
                        suc.right = null;
                        root = root.right;
                    }
                } else {
                    if (pre != null && root.val < pre.val) {
                        right = root;
                        if (left == null) left = pre;
                    }
                    pre = root;
                    root = root.right;
                }
            }
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
            return right;*/
            return root;
        }
    }
}
