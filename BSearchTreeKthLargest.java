/**
 * @className: BinarySearchTreeKthLargest
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * @author: carl
 * @date: 2021/8/20 23:04
 */

public class BSearchTreeKthLargest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int result, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            result = node.val;
        }
        dfs(node.left);
    }
}

