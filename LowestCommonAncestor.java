/**
 * @className: LowestCommonAncestor
 * @description: 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @author: Carl Tong
 * @date: 2022/3/21 14:14
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果是空，直接返回null
        if (root == null) return null;
        // 如果找到结点，返回
        if (root == p || root == q) return root;
        // 否则，从左子树、右子树找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树找不到，则 p 和 q 一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先；反之同理
        if (left == null) return right;
        else if (right == null) return left;
        // 如果都不为空，说明在p、q在root异侧，最近公共祖先即为 root
        else return root;
    }
}
