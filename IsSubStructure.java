/**
 * @className: IsSubStructure
 * @description: 剑指 Offer 26. 树的子结构
 * @author: carl
 * @date: 2021/8/23 16:32
 */

public class IsSubStructure {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode father, TreeNode sub) {
        if (sub == null) {
            return true;
        }
        if (father == null || father.val != sub.val) {
            return false;
        }
        return recur(father.left, sub.left) && recur(father.right, sub.right);
    }
}
