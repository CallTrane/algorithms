/**
 * @className: IsSymmetric
 * @description: 101. 对称二叉树
 * @author: Carl Tong
 * @date: 2022/2/23 2:23
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left== null ^ right == null) return false;
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
