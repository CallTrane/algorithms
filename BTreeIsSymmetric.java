/**
 * @className: BTreeIsSymmetric
 * @description: 剑指 Offer 28. 对称的二叉树 || 101. 对称二叉树
 * @author: carl
 * @date: 2021/9/16 15:41
 */
public class BTreeIsSymmetric {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
