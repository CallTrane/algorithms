/**
 * @className: KthSmallest
 * @description: 230. 二叉搜索树中第K小的元素
 * @author: carl
 * @date: 2021/9/12 22:32
 */
public class KthSmallest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int result = 0, k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode node) {
        if (node == null || k <= 0) {
            return;
        }
        dfs(node.left);
        if (k-- == 1) {
            result = node.val;
        }
        dfs(node.right);
    }
}
