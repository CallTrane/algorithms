package 树;

/**
 * @className: IsUnivalTree
 * @description: 965. 单值二叉树
 * @author: Carl Tong
 * @date: 2022/5/24 0:33
 */
public class IsUnivalTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return dfs(root, root.left) && dfs(root, root.right);
    }

    public boolean dfs(TreeNode root, TreeNode cur) {
        if (cur == null) return true;
        if (cur.val != root.val) return false;
        return dfs(cur, cur.left) && dfs(cur, cur.right);
    }
}
