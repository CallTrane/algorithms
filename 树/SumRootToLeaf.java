package 树;

/**
 * @className: SumRootToLeaf
 * @description: 1022. 从根到叶的二进制数之和
 * @author: Carl Tong
 * @date: 2022/5/30 14:42
 */
public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) return 0;
        val = (val << 1) | node.val;
        // 如果是叶子节点, 直接返回
        if (node.left == null && node.right == null) return val;
        // 否则返回左右子树之和
        return dfs(node.left, val) + dfs(node.right, val);
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
